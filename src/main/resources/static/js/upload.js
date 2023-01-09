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
    //sendDataXMLHttpRequest();
    sendDatajQuery();
    dialog.close();

}, false);

no.addEventListener('click', function() { 
    // いいえボタンをクリックした場合の処理    
    dialog.close();
}, false);

/**
 * 普通のJavascriptで実装
 */
function sendDataXMLHttpRequest(){
    // ファイルを取得
    let file = document.getElementById('file').files[0];

    // フォームデータを設定
    let formdata = new FormData();
    formdata.append( "file", file);
     
    let xmlhttp = new XMLHttpRequest();

    xmlhttp.onload = function(){
        alert("成功");
    }

    xmlhttp.onerror = function(){
        alert("失敗");
    }

    xmlhttp.open("POST", "/uploadFile", true);
    xmlhttp.send(formdata);
}

/**
 * jQueryで実装
 */
function sendDatajQuery(){
    // ファイルを取得
    let file = $('#file')[0].files[0];

    // フォームデータを取得
    let formdata = new FormData();
    formdata.append( "file", file);
     
    // POSTでアップロード
	$.ajax({
          url  : "/uploadFile",
          type : "POST",
          data : formdata,
          cache       : false,
          contentType : false,
          processData : false,
          dataType    : "html"
      })
      .done(function(){
          alert("成功");
      })
      .fail(function(){
          alert("失敗");
      });
}