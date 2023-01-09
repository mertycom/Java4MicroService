# GENEL İÇERİK VE NOTLAR

## Docker kullanımları
    docker run --name Dockerpostgres -e POSTGRES_PASSWORD=root -p 5432:5432 -d postgres

## Microservis ya da Projenin jar olarak export edilmesi
    1- Öncelikle ilgili microservisin gradle dosyası üzerinde build olmasını sağlayın.
    2- Sonra aynı konumda iken buildDependents yapmanız gerekmektedir.
    Detaylar:
        *Bu işlemlerden sonra ilgili microservis altına build anında bir klasör görünür olacak.
    Bu klasör altında bulunan libs klasörünün altında proje isimlendirmemizin olduğu bir jar dosyası
    bulacagız.Bu jar dosyası çalıştırılabilir biçimdedir.

## Docker image oluşturma
    Öncelikle projenizin üzerinde çalışacağı mevcut bir container a ihtiyaç var.
    bizim sistemimize uygun olan bir dockerImage seçmemiz gerekiyor.
            *Bize uygun olan image JavaJDK17 olacaktır.(amazoncorretto:17)
            *Kendi jar dosyanızı bu image üzerine kopyalıyorsunuz.
            *Opsionel!: Her image genellikle eski paketleri içerir. Bu nedenle update edilmesi
        tavsiye edilir.
            *Jar dosyanızı çalıştırırsınız.(belli sistem enviroment larını belirlemeniz gerekir.)
    
    Not:Dockerfile oluşturmanın ve kullanımının 2 yolu var;
            1-Dockerfile microservice içine oluşturulur ve çalıştırılır. Güncellemek ve düzenlemek zor olabilir.
        Kodlama yaparken ilgili klasörün içinde olduğunuzdan emin olmanız gerekiyor.
            2-Dockerfile projenin root klasörüne oluşturulur ve çalıştırılır. Burada ise tek dosya üzerinden
        çalıştğı için güncelleme yapmak kolay olur. Ancak, her microservis için ayrıca klasör konumunu
        belirtmek gerekiyor.

## Docker Image Oluşturma (Dockerfile)
    1- docker build --build-arg JAR_FILE=<jar_file_name> -t <image_name> .
###
    docker build --build-arg JAR_FILE=config-server/build/libs/config-server-v.0.0.1.jar -t java4/configserver:v001 .
    docker run --name config-server -p 8888:8888 -d java4/configserver:v001 config-server 
###
    docker build --build-arg JAR_FILE=auth-microservice/build/libs/auth-microservice-v.0.0.1.jar -t java4/authmicroservice:v001 .
    docker run --name auth-microservice -p 9091:9091 -d java4/authmicroservice:v001

