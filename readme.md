<h2>Kod do zajęć z Selenium, kurs WAR_TEA_O_20</h2>

1. Po pobraniu pamiętaj, aby dograć odpowiedni driver (w zależności od przeglądarki i w zależności 
od używanego systemu operacyjnego).
2. Możliwe jest uruchomienie testów z poziomu IDE oraz konsoli:

2.1. Sprawdź w Terminalu, czy masz zainstalowany Maven
```
mvn -version
```
Jeżeli wyświetlił się numer wersji oznacza to, że wszystko jest w porządku. Jeśli wystąpił błąd, zainstaluj mavena 
(przykładowa instrukcja dla Windows - https://mkyong.com/maven/how-to-install-maven-in-windows/ 
i Linux https://www.javahelps.com/2017/10/install-apache-maven-on-linux.html
na Linuxie powinien być już zainstalowany, jeżeli użyliście skryptu z CodersLab).

2.2. Za pomocą komendy ```cd``` przejdź do folderu z projektem (tam, gdzie znajduje się plik ```pom.xml```).
2.3. Odpalenie wszystkich testów w repozytorium:
``` mvn test ```

Odpalenie testów w wybranej klasie:

```mvn clean test -Dtest=GoogleSearchTest test```

Zamiast GoogleSearchTest można podać dowolną nazwę klasy.

Jest też opcja uruchomienia konkretnego testu z klasy:

```mvn clean test -Dtest=FormTest#formTestNoFirstName test```

Spowoduje to uruchomienie testu ``formTestNoFirstName`` z klasy ``FormTest``.

Możliwe jest też uruchomienie testów pasujących do zadanego wyrażenia:

```mvn clean test -Dtest=FormTest#formTest* test```

Spowoduje uruchomienie testów zaczynających się od frazy ``formTest`` z klasy ``FormTest``. 