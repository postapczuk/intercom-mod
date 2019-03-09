# intercom-mod
This README shows how to prepare the whole setup for controlling analogue intercom via Wi-Fi using your smatphone.

## Stuff you need
1. Raspberry Pi or other device with GPIO connected to your LAN
1. S3-C relay [^*]
1. BC547 b NPN transistor [^1]
1. 1kOm resistor
1. contact plate (if you don't have soldering iron) or universal plate
1. wires

[^1]: *You can use different one, but keep in mind you need to chage the scheme*

## Schematic diagram
TBD

## Server side
You need to have python 2.7 on your device. Raspbian usually have installed package, so just to be sure you have correct version of python run the: 

```
python --version
Python 2.7.13
```

If you wish to change the default pin [^1] or time [^2] of opening function just check arguments of `open()` function and set proper arguments in `server_req.py`. Keep in mind that the scheme works only on pins without pull-up resistors.

To run server just go to the `server` catalogue from this repository to your folder, and run it:

```
cd server
sudo python server_req.py
```

[^1]: *Default value is `10`*
[^2]: *Default value is `3` seconds*

## Android smartphone
There is existing apk in the repo under the `hodor-remote-control/app/build/outputs/apk/` which you can copy to your device [^1], but if you want to build it yourself, you need to have the Android SDK and execute:

```
cd hodor-remote-control
./gradlew assembleDebug
```

It will generate apk file in folder mentioned above. 

To use app just run the ![`hodor`](https://raw.githubusercontent.com/postapczuk/intercom-mod/master/hodor-remote-control/app/src/main/res/mipmap-mdpi/ic_launcher.png "Hodor") app, set your Raspberry Pi ip and press `Open the door`

[^1]: *If you have problem with installation just check out the web how to enable installation of unknown sources*
