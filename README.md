# Heroes Projekt @BFH

## Inhaltsverzeichnis
* [Case study "Heroes" (Vorgabe des Moduls)](#case-study-heroes-vorgabe-des-moduls)
  + [Guidelines](#guidelines)
* [Änderungen / Erweiterungen](#änderungen--erweiterungen)
  + [Änderungen](#änderungen)
  + [Erweiterungen](#erweiterungen)
* [Architektur](#architektur)
  + [Übersicht](#übersicht)
  + [Module](#module)
* [Zugänge](#zugänge)
  + [Admin UI](#admin-ui)
  + [Service Discovery Dashboard](#service-discovery-dashboard)
  + [UI](#ui)
* [Installations- und Betriebsanleitung.](#installations--und-betriebsanleitung)
  + [Notwendige Tools](#notwendige-tools)
  + [Starten der Applikation](#starten-der-applikation)
  + [Mockdaten](#mockdaten)
  + [Bauen der Applikation](#bauen-der-applikation)
  + [Java Profile](#java-profile)
  + [Docker](#docker)

## Case study "Heroes" (Vorgabe des Moduls)
A simple "Arena" fight game
* 2 parties of heroes will fight against each other in the arena
* A party consists of 4 heroes
* The party with the last hero standing will be the winner
* Heroes have simple attributes like
  * Attack
  * Defend
  * Health

### Guidelines
* First just follow and imitate the case study
* Later try to extend the case study with your own ideas
  * Additional entities like weapons
  * Improved fighting algorithm with more attributes
  * Introduce hero levels that act a attribute modifiers
  * etc.
* If you feel courageous, you can also try to implement whole different case study
of your choice

## Änderungen / Erweiterungen
Da wir uns beim Handout mit dem Thema Spring Cloud auseinandergesetzt haben, haben wir uns entschieden den neuen Spring Cloud Stack anstelle des Spring Cloud Netflix Stack zu verwenden. Dadurch könnten wir viel Neues lernen und auch gerade auf dem neusten Stand bleiben.

### Änderungen
- Entfernen des `heroes` (parent) POM: Wir haben das parent POM entfernt, so dass die Microservice ohne Abhänigkeit zum parent POM gebaut werden können. Microservices sollten nach uns auch ohne das Parent POM lauffähig sein und daher haben wir uns für diesen Schritt entschieden. Die einzigen Vorteile, welche wir mit dem Parent POM gesehen haben, ist die zentrale Versionsverwaltung der Spring Boot Version, die globalen Abhängigkeiten sowie das bauen aller Module gleichzeitig. Jedoch sollte es unserer Meinung nach in einer Microservice Architektur erlaubt sein, verschiedene Versionen von bspw. Spring Cloud zu verwenden. Unter anderem aufgrund dessen, haben wir das Parent POM gelöscht.  
- Verwenden des neuen Spring Cloud Stacks: Wo möglich haben wir die neuen Komponenten des Spring Cloud Stacks verwendet und auf solche, welche im Maintenance-Mode sindnd zu verzichten.
    - Verwendung von `Spring Cloud Gateway` anstatt von `Netflix Zuul API Gateway`
    - Verwendung von `Spring Cloud LoadBalancer` anstatt von `Netflix Ribbon`
    - Leider konnten wir `Netflix Hystrix` und das `Netflix Hystrix Dashboard` nicht so leicht ersetzen, da `Feign` standardmässig `Hystrix` verwendet. Beim `Ribbon` konnten wir dies konfigurativ ausschalten, bei `Hystrix` leider nicht. Dazu kommt, dass es in der neuen Spring Cloud Welt keinen Ersatz für das `Hystrix Dashboard` gibt, so dass man selbst mit `Micrometer` und `Prometheus` sowie `Grafana` ein Monitoring aufbauen muss. Da wir bereits andere Erweiterungen implementiert haben, haben wir dies ausgelassen. 
   
### Erweiterungen
- Verwendung von `Spring Actuator` für das bereitstellen von Applikationsinfos (Status, etc.)
- Implementierung von `Spring Boot Admin` als zentrales Management-Dashboard
    - Einbindung des `Hystrix Dashboards` von `promoter` in `Spring Boot Admin`
    - Anzeigen von Logdateien, JMX Infos, etc. im Spring Boot Admin
- Verwendung von `lombok` und dessen Annotationen wie zum Beispiel
    - `@Data` anstatt von `getters` und `setters`, ...
- Verwendung von Constructor Injection im Zusammenhang mit Lombok (Annotation `@RequiredArgsConstructor`)
- Verwendung unterschiedlicher Profile für die Entwicklung und die Docker Umgebung
- Hinzufügen eines `ui` Modules mit Angular Frontend. Wird jedoch als Spring Boot Applikation verpackt, um die Integration in die Architektur zu gewährleisten (Service Discovery, API Gateway, ...).

## Architektur

### Übersicht
![Architecture overview](./doc/img/architecture.png)

### Module
Folgende Module sind vorhanden:

| Modul      | Beschreibung |
|------------|--------------|
| `admin`    | Admin UI mit `Spring Boot Admin` inkl. `Hystrix Dashboard` für `promoter` Microservice |
| `arena`    | Microservice, bei welchem sich zwei Parties bekämpfen können und der Gewinner ermittelt wird. |
| `camp`     | Hier befinden sich die Heroes und es können entsprechend neue Parties erstellt werden. |
| `frontend` | `Spring Cloud Gateway` API Gateway. Alle Microservices werden automatisch über diesen API Gateway publiziert. Dieser dient als zentraler Einstiegspunkt.             |
| `promoter` | Über den `promoter` Microservice kann entweder ein zufälliger Kampf erstellt werden oder auch einen mit zwei zuvor erstellten Parties. Der Gewinner wird über den entsprechenden `arena` Microservice ermittelt.              |
| `registry` | `Spring Cloud Eureka Server` dient als zentrale Service Discovery. Alle Applikatonen melden sich hier an und können von anderen Applikationen ermittelt werden. |
| `ui`       | Angular Frontend Applikation, bei welcher neue Parties erstellt werden können und anschliessend zu einem Kampf geschickt werden können und der Gewinner ermittelt wird. |

## Zugänge
| Zugang                                  | Über API Gateway         | Direkt \(über Docker nicht alles offen\) |
|-----------------------------------------|--------------------------|------------------------------------------|
| Service Discovery \`registry` Dashboard | \-                       | localhost:8761                           |
| Admin UI \`admin`                       | \-                       | localhost:3030                           |
| Angular Frontend \`ui` Modul            | localhost:8080/ui/       | \-                                       |
| \`arena` Microservice                   | localhost:8080/arena/    | localhost:8000                           |
| \`camp` Microservice                    | localhost:8080/camp/     | localhost:8001                           |
| \`frontend` Microservice                | localhost:8080/          | localhost:8080                           |
| \`promoter` Microservice                | localhost:8080/promoter/ | localhost:8002                           |

### Admin UI

#### Übersicht
![Admin UI overview](./doc/img/admin-ui-overview.png)

#### Microservice Übersicht
![Admin UI microservice overview](./doc/img/admin-ui-ms-overview.png)

#### Hystrix Integration
![Admin UI microservice hystrix](./doc/img/admin-ui-ms-hystrix.png)

### Service Discovery Dashboard
![Eureka Service Discovery Dashboard](./doc/img/eureka.png)

### UI
![UI](./doc/img/ui.png)

## Installations- und Betriebsanleitung.

### Notwendige Tools

- Java
- Maven
- Docker
- Docker Compose
- npm (für Angular Frontend)

### Starten der Applikation

#### Mit Docker
Falls die Images noch nicht gebuilded wurden, müssen diese zuersten mit `docker-compose build` erstellt werden.

Danach können die Microservices mit `docker compose up` gestartet werden. 
Nach einiger Zeit sind alle Microservices gestartet und an der Service Discovery angemeldet. Anschliessend sind diese über den API Gateway verfügbar.

#### Ausführen der Backend Services
Da sich die entsprechenden Microservices an der Service Registry anmelden, wird empfohlen zuerst das Modul `registry` zu starten. 

Die Microservices können auch einzelnen ausgeführt werden. Dazu navigiert man in das entsprechende Verzeichnis und führt `mvn spring-boot:run` aus. Bei dem `ui` Modul muss zusätzlich zuerst das Angular Frontend gebaut werden. Weitere Informationen sind unter dem entsprechenden Abschnitt vorhanden.
Falls der `frontend` API Gateway gestartet wurde, sind die Microservices auch über `localhost:8080/{name}/` aufrufbar. 

Für die `camp` Applikation muss lokal eine MongoDB gestartet werden. Dies kann erreicht werden, in dem schon lokal eine MongoDB Datenbank installiert und gestartet wurde oder mit `docker-compose run mongodb`.

### Mockdaten
Mockdaten für die Heroes können unter `src/main/resources/data/heroes.json` bearbeitet werden.

### Bauen der Applikation

#### Mit Docker
Die Docker Images können mit dem Befehl `docker-compose build` ausgeführt werden. Dazu werden Docker Multi-Stage Builds verwendet, um die Java sowie Angular Applikationen zu bauen.

#### Mit maven und npm
Alle Applikationen bis auf das `ui` Modul können wie folgt gebaut werden:
``mvn clean install``

Beim `ui` Modul müssen zuerst die npm Abhängigkeiten mit `npm install` installiert werden. Anschliessend müssen die Dateien in den Ordner  `/app/src/main/resources/static` kopiert werden. Schlussendlich kann der Java Microservice per `mvn clean install` gebaut werden. 

Die oben erwähnten Schritte sind mit den Docker Builds automatisiert, daher empfehlt es sich entsprechend Docker zu verwenden.

### Java Profile
| Dateiname               | Profil     | Beschreibung                                                                                    |
|-------------------------|------------|-------------------------------------------------------------------------------------------------|
| \application\.yml\      | default    | Standard Profil für die lokale Entwicklung\.                                                    |
| \application\-prd\.yml\ | Produktion | Dient zum Ausführen in Docker\. Erbt vom Standard Profil, setzt aber eine andere Registry URL\. |

### Docker
Um die entsprechenden Applikationen zu bauen sowie zu betreiben, haben wir uns für Docker entschieden. Damit man sich nicht selbst um alle notwendigen Tools (Maven, npm etc.) kümmern muss, wurde für jede Komponente ein entsprechendes Dockerfile geschrieben.

In jedem `Dockerfile` wird beschrieben, wie die Applikation gebaut werden muss, als auch wie sie gestartet werden kann. 

Um das Bauen und Starten der Microservice Architektur zu vereinfachen, haben wir zudem Docker Compose eingesetzt. Alle Microservices können so zusammen gebaut werden und entsprechend ihren Abhängigkeiten gestartet werden.

Zusätzlich zu allen Microservices welche gestartet werden, wird für die Arena noch eine MongoDB gestartet, in welcher sie die Heroes speichert.

#### Multi-Stage Builds
Folgende Stages existierteren beim Docker Build:

**dependencies**

Die Maven Abhängigkeiten werden installiert und gecached. Wird mithilfe eines Maven Images gemacht.

**build-angular**

Nur beim `ui` Modul. Die statischen Ressourcen (HTML, css, js) von Angular Frontend wird generiert. Als Basis dazu dient ein node Image.

**build/build-java**

Der `.jar` Datei des Microservice / Spring Boot Applikation wird gebaut. Wird mithilfe eines Maven Images gemacht. Beim `ui` Modul werden zusätzlich noch die generierten Angular Ressourcen in den `static` Ordner kopiert.

**default**

Die `.jar` Datei des Microservice / Spring Boot Applikation wird gestartet. Das Base Image von Docker dafür ist ein OpenJDK 11.
