function initXMLHttpRequest() {
    var xmlHttp;
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        var theVersions = new Array("MSXML2.XMLHTTP.6.0", "MSXML2.XMLHTTP.5.0", "MSXML2.XMLHTTP.4.0",
            "MSXML2.XMLHTTP.3.0", "MSXML2.XMLHTTP", "Microsoft.XMLHTTP");
        for (var i = 0; i < theVersions.length && !xmpHttp; i++) {
            try {
                xmlHttp = new ActiveXObject(theVersions[i]);

            }
            catch (e) { xmlHttp = null; }
        }
    }
    else {
        xmlHttp = null;
    }

    return xmlHttp;;

}