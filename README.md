### 🚀 Introduzione a Quarkus e al Progetto

Questo progetto è stato creato utilizzando **Quarkus**, un framework Java moderno pensato per sviluppare applicazioni leggere, 
performanti e pronte per l’ambiente cloud-native.
Quarkus è ideale per microservizi, applicazioni serverless e sistemi che richiedono tempi di avvio rapidi e basso consumo di memoria.
---

### 🛠️ Creazione del Progetto con [code.quarkus.io](https://code.quarkus.io)

Per generare la base del progetto è stato utilizzato lo **starter ufficiale** di Quarkus:  
👉 [https://code.quarkus.io](https://code.quarkus.io)
È stato utilizzato lo starter per generare automaticamente la struttura base, con le dipendenze già configurate.

### ✅ Come è stato usato:

1. ✨ Apertura del sito: [code.quarkus.io](https://code.quarkus.io)
2. ✨ Inserimento dei parametri:
    - **Group**: `com.example`
    - **Artifact**: `job-spy`
    - **Build Tool**: `Maven`
    - **Java Version**: `17`
3. ✨ Scelta delle estensioni da includere:
    - `RESTEasy Reactive`
    - `Hibernate ORM with Panache`
    - `Reactive PostgreSQL Client`
    - `Spring Data JPA`
    - `Security with JPA`
    - `Jackson`
    - `JPAStreamer`
4. ✨ Download del file `.zip` generato
5. ✨ Estrazione e apertura del progetto in un IDE per iniziare lo sviluppo

---

### 📦 Struttura e Tecnologie del Progetto

Il progetto è un'applicazione Java RESTful che utilizza PostgreSQL come database relazionale.

---

### ⚙️ Dev Mode (Modalità di sviluppo)

Durante lo sviluppo per avviare l'applicazione è possibile utilizzare il seguente comando:

```bash
./mvnw quarkus:dev
```
Questa modalità permette il live coding: le modifiche al codice si riflettono immediatamente senza riavviare il server.
La Dev Mode è utile durante la fase di sviluppo locale, ma non è pensata per ambienti di produzione.

---

### ✨ Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and Jakarta Persistence
- JPAStreamer ([guide](https://quarkiverse.github.io/quarkiverse-docs/quarkus-jpastreamer/dev/)): Express your Hibernate queries as standard Java Streams
- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
- Quarkus Extension for Spring Data JPA API ([guide](https://quarkus.io/guides/spring-data-jpa)): Use Spring Data JPA annotations to create your data access layer
- Security JPA ([guide](https://quarkus.io/guides/security-getting-started)): Secure your applications with username/password stored in a database via Jakarta Persistence
- Reactive PostgreSQL client ([guide](https://quarkus.io/guides/reactive-sql-clients)): Connect to the PostgreSQL database using the reactive pattern

---

### ✨ Quarkus
### Che cos'è Quarkus?
Quarkus è un framework Java moderno, leggero e performante, pensato per creare applicazioni cloud-native e serverless.
Si integra bene con tecnologie come Hibernate ORM, RESTEasy, CDI, e supporta reactive programming. È ottimizzato per l’esecuzione in ambienti
containerizzati e per la creazione di binari nativi (grazie a GraalVM), offrendo tempi di avvio rapidissimi e bassissimo consumo di memoria.

### Packaging e Build
./mvnw package
Compila il progetto, esegue i test, e crea un JAR eseguibile standard nella cartella target/.

./mvnw package -Pnative
Genera un binario nativo compilato tramite GraalVM. Il binario nativo è un eseguibile standalone, che non richiede JVM per partire
e ha tempi di avvio molto rapidi e footprint ridotto. Utile per deploy in ambienti serverless o container con risorse limitate.

### Gestione dell’applicazione
L’applicazione si avvia tipicamente su http://localhost:8080 (configurabile).

In ambienti di produzione o container, è possibile eseguire il file `.jar` con il comando `java -jar target/app.jar`, oppure eseguire direttamente il binario nativo (se generato).
Per fermare un’app in esecuzione su terminale:
Ctrl + C

Per fermare un’app in esecuzione su un container Docker:
docker stop <container_id>

---

### ✨ GraalVM
Per eseguire una build con GraalVM scaricare la versione compatibile con la versione Java utilizzata 
Con i seguenti comandi su Powershell si configurerà la variabile Java_Home su GraalVM senza però modificare la variabile d'ambiente del sistema. 
Questa modifica riguarderà solo il progetto in uso. 
$env:JAVA_HOME = "...\graalvm-community-openjdk-22.0.1+8.1"
$env:PATH = "$env:JAVA_HOME\bin;" + $env:PATH
$env:GRAALVM_HOME = $env:JAVA_HOME

💡 Assicurarsi di modificare il percorso in base alla posizione reale della tua installazione di GraalVM.

Il seguente comando invece permette di generare il binario nativo
./mvnw clean package "-Dnative.native-image-xmx=6g"

L'opzione -Dnative.native-image-xmx=6g aumenta la memoria heap massima disponibile per il processo di compilazione nativa, utile per evitare errori OOM (Out Of Memory).
Il binario risultante sarà disponibile nella cartella target/ e potrà essere eseguito senza JVM, rendendolo ideale per ambienti serverless, container leggeri o avvio rapido in produzione.
Il comando può impiegare diversi minuti e genererà un eseguibile nativo nella cartella `target/`.


### ✨ Che cos'è GraalVM?
GraalVM è una macchina virtuale ad alte prestazioni sviluppata da Oracle, compatibile con Java e altri linguaggi (come JavaScript, Python, Ruby).
La sua caratteristica più potente è la compilazione ahead-of-time (AOT): consente di trasformare applicazioni Java in binari nativi standalone, 
cioè eseguibili che non richiedono la JVM per funzionare.

🔧 **Quando usare GraalVM**:

✅ Microservizi e ambienti serverless dove servono:
- Tempi di avvio rapidissimi
- Consumo ridotto di memoria
- Immagini Docker più leggere

✅ Quando vuoi distribuire applicazioni come binari standalone, **senza dipendenze** da una JVM esterna.
