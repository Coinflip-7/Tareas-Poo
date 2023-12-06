Link al repositorio:
    https://gitlab.com/camilo.contreras/carrasco.alvaro-verdugo.nicolas-alvarez.sebastian-contreras.camilo-tarea2.2023.1.git

JAVAFX:
    En el desarrollo de la tarea no incorporamos el comando make JFX_OPTIONS, para que puedan elegir su ruta, en cambio cada etapa
    subimos las librerias necesarias al lib/javafx/lib, por lo solo es necesario hacer make -> make run y funcionaría el codigo.
    Eso si esto es solo para Windows x64, en caso de que quien revise la tarea no presente esta arquitectura, será necesario dirigirse al Makefile,
    y cambiar la linea:
    "JFX = --module-path lib\javafx\lib --add-modules javafx.controls,javafx.media"
    Cambiando esta parte: lib\javafx\lib , por la ruta que usted tendra del JFX.

Directorios:
    src: clases .java
    bin: clases compiladas .class
    bin/img: imagenes

Extra-crédito:
    Optamos por la Opción A
    - A1, encontramos que no estab bien especifcada, por lo que explicare lo que entendimos que habia que realizar:
        Al iniciar el programa todas las puertas y ventanas estan en verde si les pasan el mouse por encima, pero al "Armar todo", todas estas
        estarán en rojo, ya que significa que la alarma sonará. O sea el "Estar en condiciones de abrirla", se refiere si va a sonar la alarma o no.

JavaDoc:
    Para generar la documentación de JavaDoc usando intellij se va hacía la sección Tools -> Generate JavaDoc  y en Output directory se selecciona 
    donde se quiere que quede el archivo generado.

Documentacion:
    El pdf con la documentacion se encuentra en la carpeta raiz.

Makefile:
    El comando make clean funciona solo para linux, por alguna razon da error cuando se desea ejecutar con la herramienta make de windows.