Elios Interface
===============

There is 4 parts in Elios interface : toolbar, tabs, panel and log line.
The toolbar offers an easiest access to common functions.
In the tabs part, you can choose between the different panels (*Remote*, 
*Cues*, *DMX Table*, *Prefs*, *Logs* and *About*).
In the panel part, you access the panel linked to the selected tab.
In the Log line, you can read the last status log of the application.

Toolbar
-------

![Toolbar](assets/elios/Elios-01-Toolbar.png "Toolbar")

The toolbar gives you an easy access to quite common functions :

* *Enable additive mode button* : in additive mode, each new command line let 
unselected circuits in their previous state ; in non-additive mode, all 
circuits that are not selected are defaulted to 0% ;

* *DMX subnet* : select on which DMX Subnet Elios is active ;

* *DMX universe* : select on which DMX Universe of the selected Subnet 
Elios is active ;

* *Store Cue button* : allows you to store the current DMX output in a Cue 
(this is the same button than the one in *Cues* panel) ;

* *Fullscreen button* : allows you to switch on/off fullscreen mode of Elios.


Remote
------

![Remote tab](assets/elios/Elios-02-RemoteTab.png "Remote tab")

To manage circuits levels, Elios uses a simple command line syntax.
Each line is a follow of simple commands (circuits at level sets) 
separated by a ";".

On the command line panel, you can find the following symbols :

* "0".."9" : numbers used to describe circuits (between 1 and 512), 
percent levels (between 0 and 100) or DMX values (prefixed by D, between 
0 and 255) ;

* "/" : used to describe an interval (if we type "1/5", circuits 
1,2,3,4,5 will be selected) ;

* "+" : used to add some circuits to previous selection (if we type 
"1+5", circuits 1 and 5 will be selected) ;

* "-" : used to remove some circuits to the previous selection (if we 
type "1/5-3", only circuits 1,2,4,5 will be selected) ;

* "@" : used between the selection of circuits and the level ("1/5@80" 
will set circuits 1,2,3,4,5 at a level of 80%) ;

* "F" : used to affect a full level to a selection of circuits ("1/5@F" 
will set circuits 1,2,3,4,5 at a 100% level) ;

* "D" : used to set level as DMX value ("1/5@D200" will set circuits 
1,2,3,4,5 at a 200 DMX value) ;
* ";" : used to separate simple commands ("1/5@50;7@80" will set 
circuits 1,2,3,4,5 at a 50% level and circuit 7 at a 80% level).

With this syntax, you can run quite touchy commands.
For example, if you type "1/5-4+10/12+7@80;20/24-21-23@D5", you will set 
1,2,3,5,7,10,11,12 at 80% and 20,22,23 at a 5 DMX value.

If you don't write the level part of the command, circuits will be set 
to full ("1/5-4+10/12+7" will set circuits 1,2,3,5,7,10,11,12 at 
a 100% level).

To run a command line, hit the *Enter* button. If you want to delete all 
the last char, hit *Del* or if you prefer to remove everything on 
the line, hit *Reset*.

The commands are sent on the Subnet and Universe selected in the toolbar.

Cues
----

![Cues tab](assets/elios/Elios-03-CuesTab.png "Cues tab")

The Cues panel allows you to save and load states of the DMX array.

To store a cue, click on the *Store* button, then enter an unused name 
in the dialog that appears and click *Ok*.

To load a cue, select a cue in the list and click on the *Load* button, 
or just double-click on the cue in the list.

To delete a cue, select a cue in the list, click on the *Delete* button,
and confirm your choice in the dialog that appears.

DMX Table
---------

![DMX Table tab](assets/elios/Elios-04-DMXTableTab.png "DMX Table tab")

DMX Table panel shows you the current state of input and output
of the ArtNetServer on the subnet and universe selected in the toolbar.

You can have more accurate information (channel number, percent and DMX values) 
of each channel by putting your cursor over the corresponding cell. 

Cues are saved when Elios is closed. You will find them back when you will reopen the app.

Preferences
-----------

![Preferences tab](assets/elios/Elios-05-PrefsTab.png "Preferences tab")

On the Prefs panel, you can set all application settings :

* *Language* : choose the language of Elios interface ;

* *Check update* : choose the frequency of checking for new versions of Elios ;

* *Broadcast address* : the IP address on which ArtNet packets are 
broadcasted (use 127.255.255.255 if the node is on the same computer 
than Elios ; use 2.255.255.255 or 10.255.255.255 following IP addresses 
of the nodes on your network) ;

* *In Port* : the port on which Elios is listening the network (**do not use 
something else than 6454 if you don't know what you are doing**) ;

* *Out Port* : the port on which Elios is emetting the network (**do not use 
something else than 6454 if you don't know what you are doing**) ;

* *Enable Http Server* : with the http server enabled, you can access 
Elios via your favorite web browser on any device device connected on 
the same network (just type http://2.0.0.1:8080 on your browser where 
2.0.0.1 is the IP of the computer running Elios and 8080 the HTTP port 
that has been set in the prefs panel) ;

* *Http port* : the port on which Elios HTTP server is listening (default 
to 8080) ;

* *Cancel / Save buttons* : these buttons are used to save or cancel 
preferences changes (when you save new preferences, ArtNet server and
HTTP server are restarted) ;

Logs
----

![Logs tab](assets/elios/Elios-06-LogsTab.png "Logs tab")

On the logs panel you can see all the things that have been done in 
Elios : start and stop of server, parse of command line, errors 
encountered...
If you wand to clear the logs, just hit "Clear Logs" button.

About
-----

![About tab](assets/elios/Elios-07-AboutTab.png "About tab")

That's just a simple panel displaying the names of people working on 
Elios and version number...
