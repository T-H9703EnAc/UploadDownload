let dialog = document.querySelector('dialog');
let btn = document.getElementById('btn');
let yes = document.getElementById('yes');
let no = document.getElementById('no');


btn.addEventListener('click', function() {
	// 開くボタンをクリックした場合の処理
	dialog.showModal();
}, false);

yes.addEventListener('click', function() {
	// はいボタンをクリックした場合の処理
	getDataXMLHttpRequest();
	dialog.close();

}, false);

no.addEventListener('click', function() {
	// いいえボタンをクリックした場合の処理    
	dialog.close();
}, false);

/**
 * 普通のJavascriptで実装
 */
function getDataXMLHttpRequest() {

	let xmlhttp = new XMLHttpRequest();

	xmlhttp.onload = function(data) {
		let filename = "";
		// サーバ側で設定したファイル名を正規表現で取得
		let disposition = xmlhttp.getResponseHeader('Content-Disposition');
		if (disposition && disposition.indexOf('attachment') !== -1) {
			let filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
			let matches = filenameRegex.exec(disposition);
			if (matches != null && matches[1]) {
				filename = matches[1].replace(/['"]/g, '');
			}
		}
		let blob = new Blob([data.target.response]);
		let objURL = window.URL.createObjectURL(blob);
		// リンクを生成し、JavaScriptからクリック
		let a = document.createElement("a");
		document.body.appendChild(a);
		a.href = objURL;
		a.download = filename;
		a.click();
	}

	xmlhttp.onerror = function() {
		alert("失敗");
	}

	xmlhttp.open("POST", "/downloadFile", true);
	xmlhttp.send();
}

/**
 * jQueryで実装
 */
function getDatajQuery() {
	// POSTでアップロード
	$.ajax({
		url: "/downloadFile",
		type: "POST",
		cache: false,
		contentType: false,
		processData: false,
		dataType: "html"
	})
		.done(function(data) {
			let fileName = 'test.txt';
			let blob = new Blob([data]);
			let objURL = window.URL.createObjectURL(blob);
			// リンクを生成し、JavaScriptからクリック
			let a = document.createElement("a");
			document.body.appendChild(a);
			a.href = objURL;
			a.download = fileName;
			a.click();
		})
		.fail(function() {
			alert("失敗");
		});
}