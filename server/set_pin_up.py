#!/usr/bin/env/python
import RPi.GPIO as GPIO
import time

def open(pin=10, lengthSeconds=3):
  print "opening the doors"
  GPIO.setmode(GPIO.BCM)
  GPIO.setup(pin,GPIO.OUT)
  GPIO.output(pin,GPIO.HIGH)
  time.sleep(lengthSeconds)
  GPIO.cleanup()
  print "doors opened"
