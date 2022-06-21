# AndroidChatApp
a chat app based on android
In this part of the project- assignment 3- we "converted" the chat app to run on android in additin to web.
we build:
1. login screen - it the main activity. we did 2 fields: 1. username 2. password and button for enter. you can move with another btn to register page.
2. resign screen with fitcher you can delete via the settings, the "suprise button" . we did fieldes as requested: 1. username-id 2. nickname 3.password 4.validate 5.pic we didnt do because we didnt get an answer if the user should upload it. We added validation on each field like empty or wrong one, ot wrong characters. 
4. settings screen- you can change there the color theme of app and delete fitcher " toast", the app is saving the choices.
5. contact screen- you can see ther alll the contacts of the user, if you touch one of them it will lead you to the chat with the spreific contact. each contact include: 1. nickname  2. lastDate of message 3. default pic 4.last message . we added btn for adding contact
6. add contact screen- there you can add contact, to give the ability to send or get message through "Firbase" from him we needed "token" is the name of the server, we assumed the user know it and enter it + field for nickname + field for username - so we can find it in our server.
9. chat screen tou can see there history of chat messages and send messages, we design it so you can see the nickname and the pic of the contact at the top of the sceen, and you can send a message at the button.
 we added a horizontal layout of chat and we have in settings button to change color.
In all the screens wepay much attention on the design and made the app fun to look at,We worked really hard and added entitys for using ROOm, so you can see the app is saving the data localy, each time you open it. If you want to cleare the tables- just disable the comment "nukeTable" for once running the app, and then run it again wth the command "nuketabl as commeant. The comment nuke table are in java class both in contact activity and in chat activity.
. We used 2 entitys for using ROOM - messages and contacts, we created 2 adapters for showing the list on screen. We also made the lists scrolable - both the contacts and the messages. We added API to use our server from assignment 2, and we connected our project to the firebase and get our app token from there, in order to connecr our room with the server (updating the room via server at the start of the app and update the server via ROOM at the end of the app) we also created repository for contacts and view model for contacts-  but we Didnt successede in this short of time to get the right connection betwwen our ROOM (works perfectky) with the server. We also couldnt successedd in coonected to the firebase to get and send messages from oythers servers. 
We worked al lot of time on this project and hope you can see this .

so- for connecting our app to the server you need-
1. launch visual stuido- our assignment2
2. launch android atudio
3. enter user name aviya1 password Aviya1- it saved in MARIA DB (see more instruction on our assignment 2 )

enjoy our first app!
ori david and avia


