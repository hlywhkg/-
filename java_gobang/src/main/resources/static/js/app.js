gameInfo = {
    roomId: null,
    thisUserId: null,
    thatUserId: null,
    isWhite: true,
}

//////////////////////////////////////////////////
// 设定界面显示相关操作
//////////////////////////////////////////////////

function setScreenText(me) {
    let screen = document.querySelector('#screen');
    if (me) {
        screen.innerHTML = "轮到你落子了!";
    } else {
        screen.innerHTML = "轮到对方落子了!";
    }
}

//////////////////////////////////////////////////
// 初始化 websocket
//////////////////////////////////////////////////
// TODO

//////////////////////////////////////////////////
// 初始化一局游戏
//////////////////////////////////////////////////
function initGame() {
    // 是我下还是对方下. 根据服务器分配的先后手情况决定
    let me = gameInfo.isWhite;
    // 游戏是否结束
    let over = false;
    let chessBoard = [];
    //初始化chessBord数组(表示棋盘的数组)
    for (let i = 0; i < 15; i++) {
        chessBoard[i] = [];
        for (let j = 0; j < 15; j++) {
            chessBoard[i][j] = 0;
        }
    }
    let chess = document.querySelector('#chess');
    let context = chess.getContext('2d');
    context.strokeStyle = "#BFBFBF";
    // 背景图片
    let logo = new Image();
    logo.src = "img/sky.jpeg";
    logo.onload = function () {
        context.drawImage(logo, 0, 0, 450, 450);
        initChessBoard();
    }

    // 绘制棋盘网格
    function initChessBoard() {
        for (let i = 0; i < 15; i++) {
            context.moveTo(15 + i * 30, 15);
            context.lineTo(15 + i * 30, 430);
            context.stroke();
            context.moveTo(15, 15 + i * 30);
            context.lineTo(435, 15 + i * 30);
            context.stroke();
        }
    }

    // 绘制一个棋子, me 为 true
    function oneStep(i, j, isWhite) {
        context.beginPath();
        context.arc(15 + i * 30, 15 + j * 30, 13, 0, 2 * Math.PI);
        context.closePath();
        var gradient = context.createRadialGradient(15 + i * 30 + 2, 15 + j * 30 - 2, 13, 15 + i * 30 + 2, 15 + j * 30 - 2, 0);
        if (!isWhite) {
            gradient.addColorStop(0, "#0A0A0A");
            gradient.addColorStop(1, "#636766");
        } else {
            gradient.addColorStop(0, "#D1D1D1");
            gradient.addColorStop(1, "#F9F9F9");
        }
        context.fillStyle = gradient;
        context.fill();
    }

    chess.onclick = function (e) {
        if (over) {
            return;
        }
        if (!me) {
            return;
        }
        let x = e.offsetX;
        let y = e.offsetY;
        // 注意, 横坐标是列, 纵坐标是行
        let col = Math.floor(x / 30);
        let row = Math.floor(y / 30);
        if (chessBoard[row][col] == 0) {
            // TODO 发送坐标给服务器, 服务器要返回结果
            send(row,col);
            /* oneStep(col, row, gameInfo.isWhite);
            chessBoard[row][col] = 1; */

        }
    }

    function send(row, col) {
        console.log("send");
        let request = {
            message: "putChess",
            userId: gameInfo.thisUserId,
            row: row,
            col: col,
        }
        //JSON对象转换文件JSON数据
        websocket.send(JSON.stringify(request));
    }

    // TODO 实现发送落子请求逻辑, 和处理落子响应逻辑. 
}

//初始化websocket
websocket = new WebSocket("ws://127.0.0.1:8080/game");
//连接成功建立的回调方法
websocket.onopen = function (event) {
    console.log("open");
}

websocket.onmessage = function (event) {
    console.log('[handlerGameReady]: ' + event.data);

    let response = JSON.parse(event.data);
    if (response.message != 'readyGame') {
        console.log('响应类型错误!');
        return;
    }
    if (!response.ok) {
        alert('连接游戏失败! reason: ' + response.reason);
        location.assign('/game_hall.html')
        return;
    }
    // 初始化游戏信息
    gameInfo.roomId = response.roomId;
    gameInfo.thisUserId = response.thisUserId;
    gameInfo.thatUserId = response.thatUserId;
    gameInfo.isWhite = (response.whiteUserId == gameInfo.thisUserId);
    console.log('[gameReady] ' + JSON.stringify(gameInfo));
    // 初始化棋盘
    initGame();
    // 设置 #screen 的显示
    setScreenText(gameInfo.isWhite);
}

//连接关闭的回调方法
websocket.onclose = function () {
    console.log("close");
}
//连接发生错误的回调方法
websocket.onerror = function () {
    console.log("error");
    alert('和服务器连接断开! 返回游戏大厅!')
    location.assign('/game_hall.html')
};
//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function () {
    websocket.close();
}

