function date_format(dateLongType, format) {
    var date = new Date();
    date.setTime(dateLongType);
    return format.replace('y', date.getFullYear())
        .replace('m', date.getMonth() + 1)
        .replace('d', date.getDate())
        .replace('h', date.getHours())
        .replace('m', date.getMinutes())
        .replace('s', date.getSeconds());
}

function random_integer(range) {
    return parseInt(range * Math.random());
}

function api_url(url) {
    return 'http://localhost' + url;
}