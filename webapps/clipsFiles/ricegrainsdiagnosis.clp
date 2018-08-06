
(deftemplate FewGrainsInfected (slot fewGrainsInfected))
(deftemplate YellowFruiting (slot yellowFruiting))
(deftemplate VelvetySpores (slot velvetySpores))
(deftemplate ImmatureSpores (slot immatureSpores))
(deftemplate BrokenMembrane (slot brokenMembrane))
(deftemplate BlackSpots (slot blackSpots))
(deftemplate FungalGrowth (slot fungalGrowth))

(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetFewGrainsInfected
   =>
   (bind ?response (read))
   (assert (FewGrainsInfected (fewGrainsInfected ?response))))

(defrule GetYellowFruiting
   =>  
   (bind ?response (read))
   (assert (YellowFruiting (yellowFruiting ?response))))

(defrule GetVelvetySpores
   =>
   (bind ?response (read))
   (assert (VelvetySpores (velvetySpores ?response))))

(defrule GetImmatureSpores
   => 
   (bind ?response (read))
   (assert (ImmatureSpores (immatureSpores ?response))))

(defrule GetBrokenMembrane
   =>
   (bind ?response (read))
   (assert (BrokenMembrane (brokenMembrane ?response))))

(defrule GetBlackSpots
   => 
   (bind ?response (read))
   (assert (BlackSpots (blackSpots ?response))))

(defrule GetFungalGrowth
   =>
   (bind ?response (read))
   (assert (FungalGrowth (fungalGrowth ?response))))


(defrule FalseSmut
   (FewGrainsInfected (fewGrainsInfected yes))
   (YellowFruiting (yellowFruiting yes))
   (VelvetySpores (velvetySpores yes))
   (ImmatureSpores (immatureSpores yes))
   (BrokenMembrane (brokenMembrane yes))
   =>
   (assert (Diagnosis (diagnosis "False Smut")))
   (printout t "FalseSmut diagnosed" crlf))

(defrule Graindiscoluration
   (BlackSpots (blackSpots yes))
   (FungalGrowth (fungalGrowth yes))          
   =>
   (assert (Diagnosis (diagnosis "Grain discoluration")))
   (printout t "Grain discoluration diagnosed" crlf))   


(defrule CopperOxychloride 
   (Diagnosis (diagnosis FalseSmut))
   =>
   (assert (Treatment (treatment CopperOxychloride )))
   (printout t "Copper oxychloride  prescribed" crlf))

(defrule SprayCarbendazim
   (Diagnosis (diagnosis Graindiscoluration))
   =>
   (assert (Treatment (treatment SprayCarbendazimg)))
   (printout t "Spray - Carbendazimg prescribed" crlf))
