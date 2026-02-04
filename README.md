

# Moroccan Darija Translator

Ce projet est une solution complète de traduction pour la **Darija marocaine**. Il permet de traduire du contenu textuel via une interface web dédiée ou directement depuis votre navigateur grâce à une extension intégrée.

## 🎥 Démonstration
[!IMPORTANT] La vidéo de présentation (version 1) est disponible.
Elle présente le fonctionnement général du projet et une démonstration des fonctionnalités.
Cette version ne contient pas d’audio en raison d’un problème de micro.
Une version finale avec audio sera publiée dès que le problème sera résolu.
👉 **[Lien vers la vidéo de présentation (Google Drive)]([https://www.google.com/search?q=TON_LIEN_DRIVE_ICI](https://drive.google.com/file/d/1OspJ_nZlEXb5F6nkse9ujWTipWeJClC3/view?usp=drive_link))**

---

## 📁 Structure du Projet

Le projet est divisé en trois composants principaux :

1. **`TraducteurIA`** : Le moteur de traduction (Backend).
* Développé en **Java** avec **Maven**.
* Gère la logique de traduction et l'intégration éventuelle de modèles d'IA.


2. **`WebClientTranslator-main`** : L'interface utilisateur web.
* Technologies : **PHP**, **HTML**, **CSS**.
* Fournit une interface de chat et de traduction interactive.


3. **`Client_Extension`** : Extension de navigateur.
* Permet d'accéder au traducteur rapidement sans quitter l'onglet courant.
* Contient un `manifest.json`, des scripts de fond (`background.js`) et de contenu (`content.js`).



---

## 🚀 Installation et Configuration

### 1. Backend (Java)

* Naviguez dans le dossier `TraducteurIA`.
* Assurez-vous d'avoir **Maven** installé.
* Compilez le projet : `mvn clean install`

### 2. Client Web

* Déplacez le contenu de `WebClientTranslator-main` sur un serveur local (type Apache/XAMPP).
* Accédez à  `index.html` via votre navigateur.

### 3. Extension Navigateur

* Ouvrez votre navigateur (Chrome/Edge) -> **Extensions**.
* Activez le **Mode développeur**.
* Cliquez sur **Charger l'extension non empaquetée** et sélectionnez le dossier `Client_Extension`.

---

## Technologies Utilisées

* **Back-end** : Java (Maven)
* **Front-end** : PHP, HTML5, CSS3
* **Extension** : JavaScript (Web Extensions API)
* **Stockage** : Fichiers JSON (`chats.json`)



---
