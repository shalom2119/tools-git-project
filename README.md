# tools-git-project

a simple stat calculator

# the observer pattern

events
ADD event - addition of new data point
PICKER_CHANGE - change of parameter

the BarchartListener is subscribed for ADD events and adds the new data point to the bar chart
the StatePickerListener is subscibed for PICKER_CHANGE and sets the state of the Controller

when changing a paramter to calculate
when a new date point is added
NotificationService notifies the respective listener

# the state pattern

states
mode
mean

based on the parameter selected 

meanState calculates mean of dataset
modeState calculates mode of dataset

# team

sami yesuf      0923/11
samson leul     0928/11
yohannes fenta  1139/11
shalom million  0959/11



