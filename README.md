# intercom-mod
This README shows how to prepare the whole setup for controlling analogue intercom via Wi-Fi using your Raspberry Pi & Android Smatphone.

## Stuff you need
1. Raspberry Pi or other device with GPIO connected to your LAN
1. [S3-C relay](https://github.com/postapczuk/intercom-mod/blob/master/datasheets/S3.pdf.pdf) <sup>[1](#footnote1)</sup>
1. [BC547 b NPN transistor](https://github.com/postapczuk/intercom-mod/blob/master/datasheets/BC546_547_3.pdf) <sup>[1](#footnote1)</sup>
1. 1kOm resistor
1. [breadboard](https://github.com/postapczuk/intercom-mod/blob/master/breadboard.jpg "breadboard") (if you don't have soldering iron) or [pcb universal board](https://github.com/postapczuk/intercom-mod/blob/master/pcb_board.jpg "pcb universal board")
1. wires

## Server side
You need to have python 2.7 on your device. Raspbian usually have installed package, so just to be sure you have correct version of python run the: 

```
python --version
Python 2.7.13
```

If you wish to change the default pin <sup>[2](#footnote2)</sup> or time <sup>[3](#footnote3)</sup> of opening function just check arguments of `open()` function and set proper arguments in `server_req.py`. Keep in mind that the scheme works only on pins without pull-up resistors.

To run server just go to the `server` catalogue from this repository to your folder, and run it:

```
cd server
sudo python server_req.py
```

## Android smartphone
There is existing apk in the repo under the `hodor-remote-control/app/build/outputs/apk/` which you can copy to your device <sup>[4](#footnote4)</sup>, but if you want to build it yourself, you need to have the Android SDK and execute:

```
cd hodor-remote-control
./gradlew assembleDebug
```

It will generate apk file in folder mentioned above. 

To use app just run the ![`hodor`](https://raw.githubusercontent.com/postapczuk/intercom-mod/master/hodor-remote-control/app/src/main/res/mipmap-mdpi/ic_launcher.png "Hodor") app, set your Raspberry Pi ip and press `Open the door`

<img src="https://raw.githubusercontent.com/postapczuk/intercom-mod/master/Screenshot_20190309-180612.png" width="300"/>

## Schematic diagram
![scheme](https://raw.githubusercontent.com/postapczuk/intercom-mod/master/scheme.png)

## Realisation
![scheme](https://raw.githubusercontent.com/postapczuk/intercom-mod/master/IMG_20190309_161232.jpg)
![scheme](https://raw.githubusercontent.com/postapczuk/intercom-mod/master/IMG_20190309_161323.jpg)

---------------------------------------

*<a name="footnote1">1</a>: You can use different one, but keep in mind you need to chage the scheme*

*<a name="footnote2">2</a>: Default value is `10`*

*<a name="footnote3">3</a>: Default value is `3` seconds*

*<a name="footnote4">4</a>: If you have problem with installation just check out the web how to enable installation of unknown sources*
