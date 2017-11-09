$.fn.serializeJson = function() {
	var result = {};
	var formValues = this.serializeArray();
	for (var formValue, j = 0; j < formValues.length; j++) {
		formValue = formValues[j];
		var name = formValue.name;
		var value = formValue.value;
		if (name.indexOf('.') < 0) {
			var tempValue = result[name];// 如果name相同，进行值合并，以逗号分隔值;
			result[name] = tempValue ? (tempValue + "," + value) : value;
			continue;
		} else {
			var simpleNames = name.split('.');
			var obj = result;// 构建命名空间
			for (var i = 0; i < simpleNames.length - 1; i++) {
				var simpleName = simpleNames[i];
				if (simpleName.indexOf('[') < 0) {
					if (obj[simpleName] == null) {
						obj[simpleName] = {};
					}
					obj = obj[simpleName];
				} else { // 数组,分隔
					var arrNames = simpleName.split('[');
					var arrName = arrNames[0];
					var arrIndex = parseInt(arrNames[1]);
					if (obj[arrName] == null) {
						obj[arrName] = []; // new Array();
					}
					obj = obj[arrName];
					multiChooseArray = result[arrName];
					if (obj[arrIndex] == null) {
						obj[arrIndex] = {}; // new Object();
					}
					obj = obj[arrIndex];
				}
			}

			if (obj[simpleNames[simpleNames.length - 1]]) {
				var temp = obj[simpleNames[simpleNames.length - 1]];
				obj[simpleNames[simpleNames.length - 1]] = temp;
			} else {
				obj[simpleNames[simpleNames.length - 1]] = value;
			}
		}
	}
	return result;
}

function overrideJSON(dest, orgi) {
	var target = {};
	for ( var d in dest) {
		var gv = orgi[d];
		if (!gv) {
			dest[d] = '';
		}
	}
	return $.extend(target, dest, orgi);
}

function returnFloat(value) {
	var value = Math.round(parseFloat(value) * 100) / 100;
	var xsd = value.toString().split(".");
	if (xsd.length == 1) {
		value = value.toString() + ".00";
		return value;
	}
	if (xsd.length > 1) {
		if (xsd[1].length < 2) {
			value = value.toString() + "0";
		}
		return value;
	}
}

function formatCurrency(num) {
	if (num) {
		// 将num中的$,去掉，将num变成一个纯粹的数据格式字符串
		num = num.toString().replace(/\$|\,/g, '');
		// 如果num不是数字，则将num置0，并返回
		if ('' == num || isNaN(num)) {
			return 'Not a Number ! ';
		}
		// 如果num是负数，则获取她的符号
		var sign = num.indexOf("-") > 0 ? '-' : '';
		// 如果存在小数点，则获取数字的小数部分
		var cents = num.indexOf(".") > 0 ? num.substr(num.indexOf(".")) : '';
		cents = cents.length > 1 ? cents : '';// 注意：这里如果是使用change方法不断的调用，小数是输入不了的
		// 获取数字的整数数部分
		num = num.indexOf(".") > 0 ? num.substring(0, (num.indexOf("."))) : num;
		// 如果没有小数点，整数部分不能以0开头
		if ('' == cents) {
			if (num.length > 1 && '0' == num.substr(0, 1)) {
				return 'Not a Number ! ';
			}
		}
		// 如果有小数点，且整数的部分的长度大于1，则整数部分不能以0开头
		else {
			if (num.length > 1 && '0' == num.substr(0, 1)) {
				return 'Not a Number ! ';
			}
		}
		// 针对整数部分进行格式化处理，这是此方法的核心，也是稍难理解的一个地方，逆向的来思考或者采用简单的事例来实现就容易多了
		/*
		 * 也可以这样想象，现在有一串数字字符串在你面前，如果让你给他家千分位的逗号的话，你是怎么来思考和操作的? 字符串长度为0/1/2/3时都不用添加 字符串长度大于3的时候，从右往左数，有三位字符就加一个逗号，然后继续往前数，直到不到往前数少于三位字符为止
		 */
		for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++) {
			num = num.substring(0, num.length - (4 * i + 3)) + ',' + num.substring(num.length - (4 * i + 3));
		}
		// 将数据（符号、整数部分、小数部分）整体组合返回
		return (sign + num + cents);
	}
}

function outputmoney(number) {
	number = number.replace(/\,/g, "");
	if (isNaN(number) || number == "")
		return "";
	number = Math.round(number * 100) / 100;
	if (number < 0)
		return '-' + outputdollars(Math.floor(Math.abs(number) - 0) + '') + outputcents(Math.abs(number) - 0);
	else
		return outputdollars(Math.floor(number - 0) + '') + outputcents(number - 0);
}
// 格式化金额
function outputdollars(number) {
	if (number.length <= 3)
		return (number == '' ? '0' : number);
	else {
		var mod = number.length % 3;
		var output = (mod == 0 ? '' : (number.substring(0, mod)));
		for (i = 0; i < Math.floor(number.length / 3); i++) {
			if ((mod == 0) && (i == 0))
				output += number.substring(mod + 3 * i, mod + 3 * i + 3);
			else
				output += ',' + number.substring(mod + 3 * i, mod + 3 * i + 3);
		}
		return (output);
	}
}
function outputcents(amount) {
	amount = Math.round(((amount) - Math.floor(amount)) * 100);
	return (amount < 10 ? '.0' + amount : '.' + amount);
}

function clearnumber(str) {
	str = str.replace(/,/g, "");// 取消字符串中出现的所有逗号
	return str;
}