
(deftemplate OvalLessions (slot ovalLessions))
(deftemplate BlightingLeaf (slot blightingLeaf))
(deftemplate OvalPustules (slot ovalPustules))
(deftemplate RustSpores (slot rustSpores))
(deftemplate GallsEars (slot gallsEars))
(deftemplate GallsWhite (slot gallsWhite))
(deftemplate DarkSpores (slot darkSpores))
(deftemplate RollingLeaves (slot rollingLeaves))
(deftemplate LeatheryLeaves (slot leatheryLeaves))
(deftemplate WavyMargin (slot wavyMargin))
(deftemplate IrregularSpots (slot irregularSpots))
(deftemplate BacterialExudates (slot bacterialExudates))
(deftemplate OrangeVascular (slot orangeVascular))
(deftemplate NecroticSpots (slot necroticSpots))
(deftemplate GrayAppearance (slot grayAppearance))
(deftemplate ParallelEdges (slot parallelEdges))
(deftemplate RedLeaves (slot redLeaves))
(deftemplate StuntedPlants (slot stuntedPlants))
(deftemplate TornLeaves (slot tornLeaves))
(deftemplate CigarShaped (slot cigarShaped))
(deftemplate Sporulation (slot sporulation))
(deftemplate BrownLessions (slot brownLessions))
(deftemplate WhiteStrips (slot whiteStrips))
(deftemplate NarrowLeaves (slot narrowLeaves))
(deftemplate DownyMycelium (slot downyMycelium))

(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetOvalLessions
   =>
   (bind ?response (read))
   (assert (OvalLessions (ovalLessions ?response))))

(defrule GetBlightingLeaf
   =>  
   (bind ?response (read))
   (assert (BlightingLeaf (blightingLeaf ?response))))

(defrule GetOvalPustules
   =>
   (bind ?response (read))
   (assert (OvalPustules (ovalPustules ?response))))

(defrule GetRustSpores
   => 
   (bind ?response (read))
   (assert (RustSpores (rustSpores ?response))))

(defrule GetGallsEars
   =>
   (bind ?response (read))
   (assert (GallsEars (gallsEars ?response))))

(defrule GetGallsWhite
   => 
   (bind ?response (read))
   (assert (GallsWhite (gallsWhite ?response))))

(defrule GetDarkSpores
   =>
   (bind ?response (read))
   (assert (DarkSpores (darkSpores ?response))))
   
(defrule GetRollingLeaves
   =>
   (bind ?response (read))
   (assert (RollingLeaves (rollingLeaves ?response))))

(defrule GetLeatheryLeaves
   =>  
   (bind ?response (read))
   (assert (LeatheryLeaves (leatheryLeaves ?response))))

(defrule GetWavyMargin
   =>
   (bind ?response (read))
   (assert (WavyMargin (wavyMargin ?response))))

(defrule GetIrregularSpots
   => 
   (bind ?response (read))
   (assert (IrregularSpots (irregularSpots ?response))))

(defrule GetBacterialExudates
   =>
   (bind ?response (read))
   (assert (BacterialExudates (bacterialExudates ?response))))

(defrule GetOrangeVascular
   => 
   (bind ?response (read))
   (assert (OrangeVascular (orangeVascular ?response))))

(defrule GetNecroticSpots
   =>
   (bind ?response (read))
   (assert (NecroticSpots (necroticSpots ?response))))

(defrule GetGrayAppearance
   =>
   (bind ?response (read))
   (assert (GrayAppearance (grayAppearance ?response))))

(defrule GetParallelEdges
   => 
   (bind ?response (read))
   (assert (ParallelEdges (parallelEdges ?response))))

(defrule GetRedLeaves
   =>
   (bind ?response (read))
   (assert (RedLeaves (redLeaves ?response))))
   
(defrule GetStuntedPlants
   =>
   (bind ?response (read))
   (assert (StuntedPlants (stuntedPlants ?response))))

(defrule GetTornLeaves
   =>  
   (bind ?response (read))
   (assert (TornLeaves (tornLeaves ?response))))

(defrule GetCigarShaped
   =>
   (bind ?response (read))
   (assert (CigarShaped (cigarShaped ?response))))

(defrule GetSporulationy
   => 
   (bind ?response (read))
   (assert (Sporulation (sporulation ?response))))

(defrule GetBrownLessions
   =>
   (bind ?response (read))
   (assert (BrownLessions (brownLessions ?response))))

(defrule GetWhiteStrips
   => 
   (bind ?response (read))
   (assert (WhiteStrips (whiteStrips ?response))))

(defrule GetNarrowLeaves
   =>
   (bind ?response (read))
   (assert (NarrowLeaves (narrowLeaves ?response))))

(defrule GetDownyMycelium
   =>
   (bind ?response (read))
   (assert (DownyMycelium (downyMycelium ?response))))

(defrule AnthracnoseLeafBlight
   (OvalLessions (ovalLessions yes))
   (BlightingLeaf (blightingLeaf yes))  
   =>
   (assert (Diagnosis (diagnosis "Anthracnose Leaf Blight")))
   (printout t "Anthracnose Leaf Blight diagnosed" crlf))

(defrule CommonRust
   (OvalPustules (ovalPustules yes))
   (RustSpores (rustSpores yes))         
   =>
   (assert (Diagnosis (diagnosis "Common Rust")))
   (printout t "Common Rust diagnosed" crlf))
      
(defrule CommonSmut 
   (GallsEars (gallsEars yes))
   (GallsWhite (gallsWhite yes))
   (DarkSpores (darkSpores yes))  
   =>
   (assert (Diagnosis (diagnosis "Common Smut")))
   (printout t "Common Smut diagnosed" crlf))

(defrule CrazyTop
   (RollingLeaves (rollingLeaves yes))
   (LeatheryLeaves (leatheryLeaves yes))          
   =>
   (assert (Diagnosis (diagnosis "Crazy Top")))
   (printout t "Crazy Top diagnosed" crlf))

 (defrule BacterialWilt
   (WavyMargin (wavyMargin yes))
   (IrregularSpots (irregularSpots yes))
   (BacterialExudates (bacterialExudates yes))
   (OrangeVascular (orangeVascular yes))          
   =>
   (assert (Diagnosis (diagnosis "Bacterial Wilt")))
   (printout t "BacterialWilt" crlf))
   
(defrule GrayLeafSpot
   (NecroticSpots (necroticSpots yes))
   (GrayAppearance (grayAppearance yes))
   (ParallelEdges (parallelEdges yes))          
   =>
   (assert (Diagnosis (diagnosis "Gray Leaf Spot")))
   (printout t "Gray Leaf Spot Ear Rot" crlf))
   
(defrule MaizeChloroticDwarfVirus
   (RedLeaves (redLeaves yes))
   (StuntedPlants (stuntedPlants yes))
   (TornLeaves (tornLeaves yes))          
   =>
   (assert (Diagnosis (diagnosis "Maize Chlorotic Dwarf Virus")))
   (printout t "Maize Chlorotic Dwarf Virus" crlf))
   
(defrule NorthernCornLeafBlight
   (CigarShaped (cigarShaped yes))
   (Sporulation (sporulation yes))         
   =>
   (assert (Diagnosis (diagnosis "Northern Corn Leaf Blight")))
   (printout t "Northern Corn Leaf Blight" crlf))   
   
 (defrule NorthernCornLeafSpot
   (OvalLessions (ovalLessions yes))         
   =>
   (assert (Diagnosis (diagnosis "Northern Corn Leaf Spot")))
   (printout t "Northern Corn Leaf Spot" crlf))  
      
(defrule PhysodermaBrownSpot
   (BrownLessions (brownLessions yes))         
   =>
   (assert (Diagnosis (diagnosis "Physoderma Brown Spot")))
   (printout t "Physoderma Brown Spot" crlf))   

(defrule SorghumDownyMildew
   (WhiteStrips (whiteStrips yes))
   (NarrowLeaves (narrowLeaves yes))
   (DownyMycelium (downyMycelium yes))
   (StuntedPlants (stuntedPlants yes))         
   =>
   (assert (Diagnosis (diagnosis "Sorghum Downy Mildew")))
   (printout t "Sorghum Downy Mildew" crlf))

(defrule SouthernRust
   (OvalPustules (ovalPustules yes))         
   =>
   (assert (Diagnosis (diagnosis "Southern Rust")))
   (printout t "Southern Rust" crlf))
        