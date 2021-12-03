/**
 * 获取指定范围的数值
 * @param minNum 最小值
 * @param maxNum 最大值
 * @returns number 整型数值
 */
function getRandomNum(minNum, maxNum) {
    return Math.floor(Math.random() * maxNum + minNum);
}

/**
 * 获取指定长度的随机验证码
 * @param len
 * @returns {string}
 */
function getRandomCode(len = 4) {
    let letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];
    let codes = [];
    for (let i = 0; i < len; i++) {
        let index = getRandomNum(0, letters.length);
        let code = getRandomNum(0,1) ? letters[index] : letters[index].toUpperCase();
        codes.push(code);
    }
    return codes.join('');
}

/**
 * 绘制彩色验证码
 * @returns string 验证码节点
 */
function colorCode(code) {
    let dom = "";
    code.split('').forEach(function (item, index) {
        let red = getRandomNum(0, 255);
        let green = getRandomNum(0, 255);
        let blue = getRandomNum(0, 255);
        let rotate = getRandomNum(-60, 60);
        let marginX = getRandomNum(0, 5);
        dom += "<span style='color:rgb(" + red + "," + green + "," + blue + ");transform: rotate(" + rotate + "deg);display: inline-block;margin-left: " + marginX + "px'>" + item + "</span>";
    });
    return dom;
}