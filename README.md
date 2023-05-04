Docker için:
İlk önce "sh build.sh"
Daha sonra "sh run.sh"sh 

İlk build uzun sürüyor, çünkü dependencyler iniyor.
Daha sonrakiler hep hızlı.

Ideler için, Main.java dosyası çalıştırılacak.

Windows makineler için, mvn package denildiği zaman runnable jar file oluşuyor.
java -jar SmartPulse-Internship-TradeStatistics-jar-with-dependencies.jar 
komutu ile çalıştırılabilir.

Target ve .idea githuba gönderilmeyecek. 

Java 19 kullanıldı. Pom.xml'deki java seviyesi düşürülerek başka versiyonlar ile çalıştırılabilir. 
Connection class ı singleton tanımlandı.

Klasör yapısı ve dosya yapısını değiştirme.

Tarihleri main/resource/config.properties dosyasından değiştirilebilir.
Parametre olarak okudum. İstersek input olarak da alabilirdik.
