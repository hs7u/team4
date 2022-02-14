function subData() {
    let data = {
            action: "income"
        }
    return JSON.stringify(data);
}
function callState(){
    if(xhr.readyState == 4){    //readyState: 0 -> 1 -> 2 -> 3 -> 4
        if(xhr.status == 200){
            let value = `${xhr.responseText}`;
            self.postMessage(value);
        }
    }   
}
setInterval(function(){
        let fdate = subData();
        xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange',callState);
        let urlSource = '../../dashBoard';
        xhr.open('POST', urlSource, true); // if false --> 同步 | true: 非同步
        xhr.send(fdate);
}, 1000);

