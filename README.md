
===== Dimensions Scalable Android (DSA) for the Android Design guidelines. ======
By CodingZip(Drex) 

version: 1.0

_______the executable jar file or .exe is in the folder -> Executable Jar or exe <-______
DSA is an xml file generator that provides scalable size units for different screen sizes.

this tool aims to generate several or a single dimension xml file for a scaling
While placing it in the corresponding folder (values-sw<N>dp) for your Android projects.

#for use in your projects read files -> HOW TO USE DSA <-
=========================================================================

With **Dimensions Scalable Android**, you can:

- Select and duplicate your own existing xml file as a starting point for a new scaling with a new value specify by yourself.
***NB: Please deselect the check box "use default values" to have the ability to locate your own xml file as the starting source. 

- Start from zero by generating an xml file with the default values already predefined in the tool.

- Choose the destination directory (output) or directly copy your new values (either directly to the src/ folder of your project).
  so you don’t have to move them manually.

- Generate multiple xml files at once.


***** If you generate the xml files using the default values of the tool you will benefit:*******

-values in dp ,sp ,px each between (0 and 1000 for positive values) and (0 and -1000 for negative values) 
You can use this way: @dimen/dp_50_dsa or @dimen/dp_50_minus_dsa

-also default values used for the material design in the generated xml.
read files -> HOW TO USE DSA <- for most detail.

*****************************************************************************************

-------------ATTENTION: --------------------------------------------------------
In most cases, you should always design a different layout for each folder (values-sw<N>dp) created.
example for a: (values-sw480dp) -> (layout-sw480dp)
--------------------------------------------------------------------------------

If you like this tool and want to contribute with the developer do not hesitate to forker it or share it to other dev .
Thank you. 

------------------------------------- ANECDOTE ------------------------------
 I developed this mini tools because I was tired of manually remodifying every time my existing xml file  
to adapt my design as precisely as possible for different screen sizes of devices.
So I don’t tell you about it when I had to start from scratch knowing that the values range from 0 to 1000 :(
-----------------------------------------------------------------------------


