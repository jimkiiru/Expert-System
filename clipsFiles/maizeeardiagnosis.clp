
(deftemplate YellowSpores (slot yellowSpores))
(deftemplate DarkGreen (slot darkGreen))
(deftemplate BleachedHusks (slot bleachedHusks))
(deftemplate GrayishHusk (slot grayishHusk))
(deftemplate LightEar (slot lightEar))
(deftemplate BlackEars (slot blackEars))
(deftemplate RadiatingLines (slot radiatingLines))
(deftemplate ReddishMold (slot reddishMold))
(deftemplate ReddishMycelium (slot reddishMycelium))
(deftemplate BlackFruiting (slot blackFruiting))
(deftemplate GrayMyceliumKernels (slot grayMyceliumKernels))
(deftemplate BleachedKernels (slot bleachedKernels))
(deftemplate PowderyGreen (slot powderyGreen))
(deftemplate EmbryoDiscoloration (slot embryoDiscoloration))

(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetYellowSpores
   =>
   (bind ?response (read))
   (assert (YellowSpores (yellowSpores ?response))))

(defrule GetDarkGreen
   =>  
   (bind ?response (read))
   (assert (DarkGreen (darkGreen ?response))))

(defrule GetBleachedHusks
   =>
   (bind ?response (read))
   (assert (BleachedHusks (bleachedHusks ?response))))

(defrule GetGrayishHusk
   => 
   (bind ?response (read))
   (assert (GrayishHusk (grayishHusk ?response))))

(defrule GetLightEar
   =>
   (bind ?response (read))
   (assert (LightEar (lightEar ?response))))

(defrule GetBlackEars
   => 
   (bind ?response (read))
   (assert (BlackEars (blackEars ?response))))

(defrule GetRadiatingLines
   =>
   (bind ?response (read))
   (assert (RadiatingLines (radiatingLines ?response))))
   
(defrule GetReddishMold
   =>
   (bind ?response (read))
   (assert (ReddishMold (reddishMold ?response))))

(defrule GetReddishMycelium
   =>  
   (bind ?response (read))
   (assert (ReddishMycelium (reddishMycelium ?response))))

(defrule GetBlackFruiting
   =>
   (bind ?response (read))
   (assert (BlackFruiting (blackFruiting ?response))))

(defrule GetGrayMyceliumKernels
   => 
   (bind ?response (read))
   (assert (GrayMyceliumKernels (grayMyceliumKernels ?response))))

(defrule GetBleachedKernels
   =>
   (bind ?response (read))
   (assert (BleachedKernels (bleachedKernels ?response))))

(defrule GetPowderyGreen
   => 
   (bind ?response (read))
   (assert (PowderyGreen (powderyGreen ?response))))

(defrule GetEmbryoDiscoloration
   =>
   (bind ?response (read))
   (assert (EmbryoDiscoloration (embryoDiscoloration ?response))))


(defrule Aspergillis
   (YellowSpores (yellowSpores yes))
   (DarkGreen (darkGreen yes))  
   =>
   (assert (Diagnosis (diagnosis "Aspergillis Ear Rot")))
   (printout t "Aspergillis diagnosed" crlf))

(defrule Diplodia
   (BleachedHusks (bleachedHusks yes))
   (GrayishHusk (grayishHusk yes))
   (LightEar (lightEar yes))
   (BlackEars (blackEars yes))          
   =>
   (assert (Diagnosis (diagnosis "Diplodia ear rot")))
   (printout t "Diplodia diagnosed" crlf))
      
(defrule FusariumKernel 
   (RadiatingLines (radiatingLines yes))  
   =>
   (assert (Diagnosis (diagnosis "Fusarium Kernel" )))
   (printout t "Fusarium Kernel diagnosed" crlf))

(defrule Gibberella
   (ReddishMold (reddishMold yes))
   (ReddishMycelium (reddishMycelium yes))
   (BlackFruiting (blackFruiting yes))          
   =>
   (assert (Diagnosis (diagnosis "Gibberella Ear Rot")))
   (printout t "Gibberella diagnosed" crlf))

 (defrule CobRot
   (GrayMyceliumKernels (grayMyceliumKernels yes))
   (BleachedKernels (bleachedKernels yes))          
   =>
   (assert (Diagnosis (diagnosis "Cob Rot")))
   (printout t "Cob Rot" crlf))
   
(defrule PenicilliumEarRot
   (PowderyGreen (powderyGreen yes))
   (EmbryoDiscoloration (embryoDiscoloration yes))          
   =>
   (assert (Diagnosis (diagnosis "Penicillium Ear Rot")))
   (printout t "Penicillium Ear Rot" crlf))
   
        