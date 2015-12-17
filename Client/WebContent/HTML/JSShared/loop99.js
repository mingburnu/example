for (var k = 1; k == 1; k++) {
	document.write('<table border="1">');
	for (var j = 1; j < 10; j++) {
		document.write('<tr>');
		for (var i = 1; i < 10; i++) {

			if ((j <= i) && (i * j < 10)) {

				document.write('<td>' + j + "X" + i + "=&nbsp&nbsp" + i * j + " " + '</td>');

			} else if ((j <= i) && (i * j >= 10)) {

				document.write('<td>' + j + "X" + i + "=" + i * j + " " + '</td>');

			}
		}

		document.write('</tr>');
	}
	document.write('<table>');
}