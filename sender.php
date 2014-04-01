<?php

/**
 * @author Waruna Oshan Wisumperuma
 * @contact warunaoshan@gmail.com
 */
$args = '{aS:SD,a:1}';
$shell_exec = shell_exec("java -jar '/home/trisquel/NetBeansProjects/online_print/dist/online_print.jar' " . $args);
if ($shell_exec == 1) {
    $file = '/var/wwww/print.pdf';
    header('X-Sendfile: ' . $file);
    header('Content-type: application/octet-stream');
    header('Content-Disposition: attachment; filename="' . basename($file) . '"');
} else {
    echo "app failed";
}

//
//You now have the module installed. To use it, you will need to add the following settings to your Apache configuration, or to a .htaccess file:
//
//# enable xsendfile
//XSendFile On
//
//# enable sending files from parent dirs
//XSendFileAllowAbove On
//
//The second one is optional, but it allows a useful behavior. You may want to store your protected files under the web root, so to allow xsendfile to access the files, you will need to enable XSendFileAllowAbove – otherwise you will only be able to access files that are in the same directory or in child directories of the directory, where the parsing script is.
//Sending files
//
//Sending a file with xsendfile is very straightforward:
//
//<?php
////We want to force a download box with the filename hello.txt
//header('Content-Disposition: attachment;filename=hello.txt');
// 
////File is located at /home/username/hello.txt
//header('X-Sendfile: /home/username/hello.txt');
//
//You could omit the first header, in which case the browser would not necessarily show a download file dialog. Also, the X-Sendfile header will not show up in the user’s browser, and they will never see the real location of the file they received.
//
//You will not need to send a Content-Length header, as Apache will take care of that for you.