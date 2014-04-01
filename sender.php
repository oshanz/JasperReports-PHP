<?php
/**
 * @author Waruna Oshan Wisumperuma
 * @contact warunaoshan@gmail.com
 */
$args='{aS:SD,a:1}';
$shell_exec=shell_exec("java -jar '/home/trisquel/NetBeansProjects/online_print/dist/online_print.jar' ".$args);
if($shell_exec==1) {
$file='/var/wwww/print.pdf';
header("X-Sendfile: $file");
header("Content-type: application/octet-stream");
header('Content-Disposition: attachment; filename="'.basename($file).'"');
} else {
echo "app failed";
}
