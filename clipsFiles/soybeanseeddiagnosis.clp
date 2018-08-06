
(deftemplate DampingOff (slot dampingOff))
(deftemplate BruisedStems (slot bruisedStems))
(deftemplate RottingTissue (slot rottingTissue))
(deftemplate SunkenLesion (slot sunkenLesion))

(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetDampingOff
   =>
   (bind ?response (read))
   (assert (DampingOff (dampingOff ?response))))

(defrule GetBruisedStems
   =>  
   (bind ?response (read))
   (assert (BruisedStems (bruisedStems ?response))))

(defrule GetRottingTissue
   =>
   (bind ?response (read))
   (assert (RottingTissue (rottingTissue ?response))))

(defrule GetSunkenLesion
   => 
   (bind ?response (read))
   (assert (SunkenLesion (sunkenLesion ?response))))

(defrule SeedlingBlight  
   (DampingOff (dampingOff yes))
   (BruisedStems (bruisedStems yes)) 
   =>
   (assert (Diagnosis (diagnosis "Seedling Blight")))
   (printout t "SeedlingBlight diagnosed" crlf))

(defrule PythiumSeedling     
   (DampingOff (dampingOff yes))
   (RottingTissue (rottingTissue yes))         
   =>
   (assert (Diagnosis (diagnosis "Pythium Seedling")))
   (printout t "PythiumSeedling" crlf))
      
(defrule RhizoctoniaRootRot  
   (SunkenLesion (sunkenLesion yes))  
   =>
   (assert (Diagnosis (diagnosis "Rhizoctonia Root Rot")))
   (printout t "RhizoctoniaRootRot diagnosed" crlf))

