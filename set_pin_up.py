#!/usr/bin/env/python
import RPi.GPIO as GPIO
import time

def open():
  print "opening the doors"
  GPIO.setmode(GPIO.BCM)
  GPIO.setup(10,GPIO.OUT)
  GPIO.output(10,GPIO.HIGH)
  time.sleep(3)
  GPIO.cleanup()
  print "doors opened"
