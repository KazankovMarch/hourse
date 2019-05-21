# Инструкция по сборке
1. Открыть терминал в рабочей папке, клонировать репозиторий: 
git clone https://github.com/KazankovMarch/hourse.git
2. Запустить Intellij IDEA, нажать "Open", выбрать из рабочей папки только что склонированную папку hourse
3. Дождаться пока Maven скачает зависимости
4. Если на вашей машине занят порт 8080, в файле 
src/main/resources/application.properties 
прописать строчку 
server.port=8080, 
вместо 8080 написав любой свободный порт. Далее вместо 8080 писать свой свободный порт
5. Запустить проект обычным способом - "зеленой кнопкой"
6. Открыть браузер, в адресной строке просписать 
"http://localhost:8080/hourse/rest/count?width=  &height=  &start=  &end=  "
 либо 
 "http://localhost:8080/hourse/servlet/count?width=  &height=  &start=  &end=  ", 
 заполнив пропуски желаемыми значениями