system = require('system');
address = system.args[1];// 获得命令行第二个参数 接下来会用到
filepath = system.args[2];// 获得命令行第二个参数 接下来会用到
var page = require('webpage').create();
var url = address;
page.open(url, function(status) {
	if (status === "success") {
		console.log(page.title);
		page.paperSize = {
			format : 'A4',
			orientation : 'portrait',
			border : '1cm'
		};
		page.render(filepath);
	}
	phantom.exit(0);
});
