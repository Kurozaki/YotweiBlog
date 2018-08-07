var Format = {};

Format.zereoill = function (num, c) {
    var s = '' + num;
    if (s.length < c) {
        return Format.zereoill('0' + s, c);
    }
    return s;
};

function urlApi(uri) {
    // return "http://localhost:8080" + uri;
    return uri;
}

function isMobile() {
    var u = navigator.userAgent;
    var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1;
    var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/);
    return isAndroid || isiOS;
}