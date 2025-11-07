# 🎮 A-Game-To-Fork

##  Funcionalidades añadidas

En esta versión del proyecto he añadido un **sistema de puntuación** para mejorar la jugabilidad y la interacción del usuario.  
Estas son las nuevas funcionalidades implementadas:

-  **Sistema de puntuación dinámico:**  
  Cada círculo que el jugador hace clic desaparece y suma puntos al marcador.  
  Los círculos más pequeños otorgan más puntos que los grandes.

-  **Línea de pérdida de vidas:**  
  Si un círculo cae más allá de la línea roja al final del panel, el jugador pierde una vida.

- ️ **Indicador de puntuación y vidas en tiempo real:**  
  Los valores de vidas y puntuación se actualizan automáticamente en la interfaz utilizando `Bindings` entre la vista (`GameController`) y el modelo (`GameModel`).

-  **Ajustes de velocidad y tamaño:**  
  Los círculos caen con una velocidad fija, pero sus tamaños se generan aleatoriamente, haciendo el juego más dinámico y desafiante.

---

##  Cómo ha sido el proceso de creación del Fork

A continuación explico cómo he creado y gestionado mi versión del proyecto paso a paso:

1. **Fork del repositorio original en GitHub**
    - Accedí al repositorio original del proyecto y pulsé el botón **“Fork”** para crear una copia en mi propia cuenta de GitHub.
    - Esto me permitió trabajar en mi propia versión sin afectar al original.

2. **Clonación del repositorio en GitKraken**
    - Abrí **GitKraken** y cloné mi fork usando la URL de mi nuevo repositorio.
    - De esta forma pude trabajar cómodamente desde la interfaz gráfica.

3. **Creación de una rama secundaria para las mejoras**
    - En GitKraken, creé una nueva rama llamada `Addascoringsystem` para añadir las nuevas funcionalidades sin modificar directamente la rama principal (`master`).

4. **Modificación del código en Java**
    - Edité el archivo `GameController.java` dentro del paquete `com.ieselgrao.gametofork.controller`.
    - Implementé el sistema de puntuación y la lógica para sumar puntos, perder vidas y actualizar los indicadores en pantalla.

5. **Commit y Push de los cambios**
    - En GitKraken, hice clic en **Stage all changes**, añadí un mensaje de commit (“Add scoring system feature”) y luego pulsé **Push** para enviar los cambios a mi fork en GitHub.

6. **Fusión de ramas (Merge)**
    - Desde GitKraken, cambié a la rama `master` y seleccioné **“Merge Addascoringsystem into master”**.
    - Tras verificar que no había conflictos, confirmé el merge y realicé un **push** final al repositorio remoto.

7. **Actualización del README.md**
    - Eliminé el archivo original `README.md` y creé uno nuevo explicando las funcionalidades añadidas y el proceso completo del fork.

---

##  Conclusión

Con esta actualización, el juego ahora cuenta con un **sistema de puntuación funcional** y una **mecánica de pérdida de vidas**, lo que añade profundidad y motivación al jugador.  
Además, aprendí a usar GitKraken para gestionar ramas, commits y fusiones de una forma visual e intuitiva.
<<<<<<< HEAD
 
=======
---

##  Capturas:

<img width="1239" height="795" alt="Screenshot 2025-11-07 at 16 18 24" src="https://github.com/user-attachments/assets/771ca799-142d-4955-b2a9-88d30e9d967d" />
<img width="702" height="795" alt="Screenshot 2025-11-07 at 16 18 41" src="https://github.com/user-attachments/assets/86df011a-ba9b-4e8d-b61f-05c76e11e3c0" />
<img width="1412" height="795" alt="Screenshot 2025-11-07 at 16 35 59" src="https://github.com/user-attachments/assets/df640026-ec2c-49e0-8705-92d4da8e09ff" />
<img width="392" height="795" alt="Screenshot 2025-11-07 at 16 39 49" src="https://github.com/user-attachments/assets/e73378b9-6e91-4975-a97f-0c8ba0727c4f" />
<img width="638" height="795" alt="Screenshot 2025-11-07 at 16 53 49" src="https://github.com/user-attachments/assets/820056ba-22b9-4448-9ff7-3a2874b8569c" />
<img width="1401" height="795" alt="Screenshot 2025-11-07 at 16 54 20" src="https://github.com/user-attachments/assets/c88468e1-916c-4327-b977-88c59e28c36d" />




>>>>>>> Addascoringsystem
