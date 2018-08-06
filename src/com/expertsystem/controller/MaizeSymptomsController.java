package com.expertsystem.controller;


import jess.Fact;
import jess.JessException;
import jess.Rete;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expertsystem.model.*;

@Controller
public class MaizeSymptomsController {

	private static Rete rete;
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value = "/maizepartsaffected", method = RequestMethod.GET)
	public ModelAndView partsAffected(HttpSession session) {
		ModelAndView mav = new ModelAndView("maizePartsAffected");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);
		
		return mav;
	}
	@RequestMapping(value = "/maizeDiagnosisResult", method = RequestMethod.GET)
	public ModelAndView diagnosisResult(@RequestParam("listValue")String listValue,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("diagnosisResult");		
		
		//SessionFactory factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session sess = factory.openSession();
		
		Query query = sess.createQuery("from MaizeDiseaseModel r where r.diseaseName=:diag");
		query.setString("diag", listValue);
		List l = query.list();		
		request.setAttribute("list", l);
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List lF = qrey.list();
		Iterator it = lF.iterator();
		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);
				
		return mav;
	}

	@RequestMapping(value = "/maizeleaf", method = RequestMethod.GET)
	public ModelAndView LeafSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("maizeLeafSymptoms");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);
		
		MaizeLeavesModel leaves = new MaizeLeavesModel();
		mav.getModelMap().put("maizeLeafSymptoms", leaves);
		return mav;
	}

	@RequestMapping(value = "/maizeear", method = RequestMethod.GET)
	public ModelAndView earSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("maizeEarsymptoms");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);
		
		MaizeEarModel ear = new MaizeEarModel();
		mav.getModelMap().put("maizeEarsymptoms", ear);
		return mav;
	}

	@RequestMapping(value = "/maizeroot", method = RequestMethod.GET)
	public ModelAndView rootSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("maizeRootSymptoms");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);
		
		MaizeRootModel root = new MaizeRootModel();
		mav.getModelMap().put("maizeRootSymptoms", root);
		return mav;
	}

	@RequestMapping(value = "/maizestalk", method = RequestMethod.GET)
	public ModelAndView stalkSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("maizeStalkSymptoms");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);
		
		MaizeStalkModel stalk = new MaizeStalkModel();
		mav.getModelMap().put("maizeStalkSymptoms", stalk);
		return mav;
	}

	@RequestMapping(value = "/maizeEarDiag", method = RequestMethod.POST)
	public ModelAndView earDiagnosis(@Valid MaizeEarModel mem,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("maizeDiseasesFound");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator itF = l.iterator();
		while (itF.hasNext()) {
			Object o = (Object) itF.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);

		rete = new Rete();
		try {
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\maizeeardiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(MaizeSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(YellowSpores (yellowSpores "+ mem.getYellowSpores() + "))");
			rete.assertString("(DarkGreen (darkGreen " + mem.getDarkGreen() + "))");
			rete.assertString("(BleachedHusks (bleachedHusks " + mem.getBleachedHusks() + "))");
			rete.assertString("(GrayishHusk (grayishHusk "+ mem.getGrayishHusk() + "))");
			rete.assertString("(LightEar (lightEar "+ mem.getLightEar() + "))");			
			rete.assertString("(BlackEars (blackEars "+ mem.getBlackEars() + "))");
			rete.assertString("(RadiatingLines (radiatingLines " + mem.getRadiatingLines() + "))");
			rete.assertString("(ReddishMold (reddishMold " + mem.getReddishMold() + "))");
			rete.assertString("(ReddishMycelium (reddishMycelium "+ mem.getReddishMycelium() + "))");
			rete.assertString("(BlackFruiting (blackFruiting "+ mem.getBlackFruiting() + "))");			
			rete.assertString("(GrayMyceliumKernels (grayMyceliumKernels "+ mem.getGrayMyceliumKernels() + "))");
			rete.assertString("(BleachedKernels (bleachedKernels " + mem.getBleachedKernels() + "))");
			rete.assertString("(PowderyGreen (powderyGreen " + mem.getPowderyGreen() + "))");
			rete.assertString("(EmbryoDiscoloration (embryoDiscoloration "+ mem.getEmbryoDiscoloration() + "))");
			
		} catch (JessException ex) {
			Logger.getLogger(MaizeSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(MaizeSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		List<String> listOfDiseases=new ArrayList<String>();
		float count=0;
		String diagnosis = "";
		try {
			rete.run();
			Iterator it = rete.listFacts();
			Fact faux;

			while (it.hasNext()) {
				faux = (Fact) it.next();
				if (faux.getName().equals("MAIN::Diagnosis")) {
					diagnosis += faux.getSlotValue("diagnosis");
					String withoutQuotes=diagnosis.replace("\"", "");
					listOfDiseases.add(withoutQuotes);
				}
				if (faux.getName().equals("MAIN::YellowSpores")) {					
					if(faux.getSlotValue("yellowSpores").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::DarkGreen")) {					
					if(faux.getSlotValue("darkGreen").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BleachedHusks")) {									
					if(faux.getSlotValue("bleachedHusks").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::GrayishHusk")) {										
					if(faux.getSlotValue("grayishHusk").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::LightEar")) {					
					if(faux.getSlotValue("lightEar").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BlackEars")) {					
					if(faux.getSlotValue("blackEars").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::RadiatingLines")) {									
					if(faux.getSlotValue("radiatingLines").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::ReddishMold")) {										
					if(faux.getSlotValue("reddishMold").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::ReddishMycelium")) {					
					if(faux.getSlotValue("reddishMycelium").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BlackFruiting")) {					
					if(faux.getSlotValue("blackFruiting").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::GrayMyceliumKernels")) {									
					if(faux.getSlotValue("grayMyceliumKernels").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BleachedKernels")) {										
					if(faux.getSlotValue("bleachedKernels").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::PowderyGreen")) {									
					if(faux.getSlotValue("powderyGreen").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::EmbryoDiscoloration")) {										
					if(faux.getSlotValue("embryoDiscoloration").equals("yes")){
						count++;
					}						
				}
				
				diagnosis="";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		DecimalFormat fmt=new DecimalFormat("0.##");
		List<String> percentList=new ArrayList<String>();
		float percent=0;
		//begin: calculate percent
		for(int i=0;i<listOfDiseases.size();i++){
		if((listOfDiseases.get(i)).equals("Aspergillis Ear Rot")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Diplodia")){
			percent=(4/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Fusarium Kernel")){
			percent=(6/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Gibberella")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Cob Rot")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Penicillium Ear Rot")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}		
		}
		//end
		
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<listOfDiseases.size();i++){
			map.put(listOfDiseases.get(i), percentList.get(i));
		}
		mav.addObject("count",count);
		request.setAttribute("maps", map);
		
		//mav.addObject("diseases", listOfDiseases);
		return mav;
	}
	
	@RequestMapping(value = "/maizeLeafDiag", method = RequestMethod.POST)
	public ModelAndView leafDiagnosis(@Valid MaizeLeavesModel mlm,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("maizeDiseasesFound");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator itF = l.iterator();
		while (itF.hasNext()) {
			Object o = (Object) itF.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);

		rete = new Rete();
		try {
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\maizeleavesdiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(MaizeSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(OvalLessions (ovalLessions "+ mlm.getOvalLessions() + "))");
			rete.assertString("(BlightingLeaf (blightingLeaf " + mlm.getBlightingLeaf() + "))");
			rete.assertString("(OvalPustules (ovalPustules " + mlm.getOvalPustules() + "))");
			rete.assertString("(RustSpores (rustSpores "+ mlm.getRustSpores() + "))");
			rete.assertString("(GallsEars (gallsEars " + mlm.getGallsEars() + "))");
			rete.assertString("(GallsWhite (gallsWhite " + mlm.getGallsWhite() + "))");
			rete.assertString("(DarkSpores (darkSpores "+ mlm.getDarkSpores() + "))");
			rete.assertString("(RollingLeaves (rollingLeaves "+ mlm.getRollingLeaves() + "))");			
			rete.assertString("(LeatheryLeaves (leatheryLeaves "+ mlm.getLeatheryLeaves() + "))");
			rete.assertString("(WavyMargin (wavyMargin " + mlm.getWavyMargin() + "))");
			rete.assertString("(IrregularSpots (irregularSpots " + mlm.getIrregularSpots() + "))");
			rete.assertString("(BacterialExudates (bacterialExudates "+ mlm.getBacterialExudates() + "))");
			rete.assertString("(OrangeVascular (orangeVascular "+ mlm.getOrangeVascular() + "))");			
			rete.assertString("(NecroticSpots (necroticSpots "+ mlm.getNecroticSpots() + "))");
			rete.assertString("(GrayAppearance (grayAppearance " + mlm.getGrayAppearance() + "))");
			rete.assertString("(ParallelEdges (parallelEdges " + mlm.getParallelEdges() + "))");
			rete.assertString("(RedLeaves (redLeaves "+ mlm.getRedLeaves() + "))");			
			rete.assertString("(StuntedPlants (stuntedPlants " + mlm.getStuntedPlants() + "))");
			rete.assertString("(TornLeaves (tornLeaves "+ mlm.getTornLeaves() + "))");
			rete.assertString("(CigarShaped (cigarShaped "+ mlm.getCigarShaped() + "))");			
			rete.assertString("(Sporulation (sporulation "+ mlm.getSporulation() + "))");
			rete.assertString("(BrownLessions (brownLessions " + mlm.getBrownLessions() + "))");
			rete.assertString("(WhiteStrips (whiteStrips " + mlm.getWhiteStrips() + "))");
			rete.assertString("(NarrowLeaves (narrowLeaves "+ mlm.getNarrowLeaves() + "))");
			rete.assertString("(DownyMycelium (downyMycelium "+ mlm.getDownyMycelium() + "))");
			
		} catch (JessException ex) {
			Logger.getLogger(MaizeSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(MaizeSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		List<String> listOfDiseases=new ArrayList<String>();
		float count=0;
		String diagnosis = "";
		try {
			rete.run();
			Iterator it = rete.listFacts();
			Fact faux;

			while (it.hasNext()) {
				faux = (Fact) it.next();
				if (faux.getName().equals("MAIN::Diagnosis")) {
					diagnosis += faux.getSlotValue("diagnosis");
					String withoutQuotes=diagnosis.replace("\"", "");
					listOfDiseases.add(withoutQuotes);
				}
				if (faux.getName().equals("MAIN::OvalLessions")) {					
					if(faux.getSlotValue("ovalLessions").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BlightingLeaf")) {					
					if(faux.getSlotValue("blightingLeaf").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::OvalPustules")) {									
					if(faux.getSlotValue("ovalPustules").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::RustSpores")) {										
					if(faux.getSlotValue("rustSpores").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::GallsEars")) {					
					if(faux.getSlotValue("gallsEars").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::GallsWhite")) {					
					if(faux.getSlotValue("gallsWhite").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::DarkSpores")) {									
					if(faux.getSlotValue("darkSpores").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::RollingLeaves")) {										
					if(faux.getSlotValue("rollingLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::LeatheryLeaves")) {					
					if(faux.getSlotValue("leatheryLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::WavyMargin")) {					
					if(faux.getSlotValue("wavyMargin").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::IrregularSpots")) {									
					if(faux.getSlotValue("irregularSpots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BacterialExudates")) {										
					if(faux.getSlotValue("bacterialExudates").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::OrangeVascular")) {									
					if(faux.getSlotValue("orangeVascular").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::NecroticSpots")) {										
					if(faux.getSlotValue("necroticSpots").equals("yes")){
						count++;
					}						
				}
				
				if (faux.getName().equals("MAIN::GrayAppearance")) {					
					if(faux.getSlotValue("grayAppearance").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::ParallelEdges")) {									
					if(faux.getSlotValue("parallelEdges").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::RedLeaves")) {										
					if(faux.getSlotValue("redLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::StuntedPlants")) {					
					if(faux.getSlotValue("stuntedPlants").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::TornLeaves")) {					
					if(faux.getSlotValue("tornLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::CigarShaped")) {									
					if(faux.getSlotValue("cigarShaped").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::Sporulation")) {										
					if(faux.getSlotValue("sporulation").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BrownLessions")) {									
					if(faux.getSlotValue("brownLessions").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::WhiteStrips")) {										
					if(faux.getSlotValue("whiteStrips").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::NarrowLeaves")) {									
					if(faux.getSlotValue("narrowLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::DownyMycelium")) {										
					if(faux.getSlotValue("downyMycelium").equals("yes")){
						count++;
					}						
				}
				
				diagnosis="";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		DecimalFormat fmt=new DecimalFormat("0.##");
		List<String> percentList=new ArrayList<String>();
		float percent=0;
		//begin: calculate percent
		for(int i=0;i<listOfDiseases.size();i++){
		if((listOfDiseases.get(i)).equals("Anthracnose Leaf Blight")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Common Rust")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Common Smut")){
			percent=(3/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Crazy Top")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Bacterial Wilt")){
			percent=(4/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Gray Leaf Spot")){
			percent=(3/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		//
		if((listOfDiseases.get(i)).equals("Maize Chlorotic Dwarf Virus")){
			percent=(3/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Northern Corn Leaf Blight")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Northern Corn Leaf Spot")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Physoderma Brown Spot")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Sorghum Downy Mildew")){
			percent=(4/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Southern Rust")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		}
		//end
		
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<listOfDiseases.size();i++){
			map.put(listOfDiseases.get(i), percentList.get(i));
		}
		mav.addObject("count",count);
		request.setAttribute("maps", map);
		
		//mav.addObject("diseases", listOfDiseases);		
		return mav;
	}
	
	@RequestMapping(value = "/maizeRootDiag", method = RequestMethod.POST)
	public ModelAndView rootDiagnosis(@Valid MaizeRootModel mrm,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("maizeDiseasesFound");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator itF = l.iterator();
		while (itF.hasNext()) {
			Object o = (Object) itF.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);

		rete = new Rete();
		try {
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\maizerootdiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(MaizeSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(SlowGrowth (slowGrowth "+ mrm.getSlowGrowth() + "))");
			rete.assertString("(YellowLeaves (yellowLeaves " + mrm.getYellowLeaves() + "))");
			rete.assertString("(LeavesDie (leavesDie " + mrm.getLeavesDie() + "))");
			rete.assertString("(BrownishLesions (brownishLesions "+ mrm.getBrownishLesions() + "))");
			rete.assertString("(BleachedLeaf (bleachedLeaf "+ mrm.getBleachedLeaf() + "))");			
			rete.assertString("(VascularDiscoloration (vascularDiscoloration "+ mrm.getVascularDiscoloration() + "))");
			rete.assertString("(NutrientDeficiency (nutrientDeficiency " + mrm.getNutrientDeficiency() + "))");
			rete.assertString("(Wilting (wilting " + mrm.getWilting() + "))");
			rete.assertString("(ShortRoots (shortRoots "+ mrm.getShortRoots() + "))");
			rete.assertString("(StubbyRoots (stubbyRoots "+ mrm.getStubbyRoots() + "))");			
			rete.assertString("(DarkLessions (darkLessions "+ mrm.getDarkLessions() + "))");
						
		} catch (JessException ex) {
			Logger.getLogger(MaizeSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(MaizeSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		List<String> listOfDiseases=new ArrayList<String>();
		float count=0;
		String diagnosis = "";
		try {
			rete.run();
			Iterator it = rete.listFacts();
			Fact faux;

			while (it.hasNext()) {
				faux = (Fact) it.next();
				if (faux.getName().equals("MAIN::Diagnosis")) {
					diagnosis += faux.getSlotValue("diagnosis");
					String withoutQuotes=diagnosis.replace("\"", "");
					listOfDiseases.add(withoutQuotes);
				}
				if (faux.getName().equals("MAIN::SlowGrowth")) {					
					if(faux.getSlotValue("slowGrowth").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::YellowLeaves")) {					
					if(faux.getSlotValue("yellowLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::LeavesDie")) {									
					if(faux.getSlotValue("leavesDie").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BrownishLesions")) {										
					if(faux.getSlotValue("brownishLesions").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BleachedLeaf")) {					
					if(faux.getSlotValue("bleachedLeaf").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::VascularDiscoloration")) {					
					if(faux.getSlotValue("vascularDiscoloration").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::NutrientDeficiency")) {									
					if(faux.getSlotValue("nutrientDeficiency").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::Wilting")) {										
					if(faux.getSlotValue("wilting").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::ShortRoots")) {					
					if(faux.getSlotValue("shortRoots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::StubbyRoots")) {					
					if(faux.getSlotValue("stubbyRoots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::DarkLessions")) {									
					if(faux.getSlotValue("darkLessions").equals("yes")){
						count++;
					}						
				}
				
				diagnosis="";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		DecimalFormat fmt=new DecimalFormat("0.##");
		List<String> percentList=new ArrayList<String>();
		float percent=0;
		//begin: calculate percent
		for(int i=0;i<listOfDiseases.size();i++){
		if((listOfDiseases.get(i)).equals("Corn Nematodes")){
			percent=(5/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Stewart Wilt")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Root Rot")){
			percent=(4/count)*100;
			percentList.add(""+fmt.format(percent));
		}
			
		}
		//end
		
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<listOfDiseases.size();i++){
			map.put(listOfDiseases.get(i), percentList.get(i));
		}
		mav.addObject("count",count);
		request.setAttribute("maps", map);
		
		//mav.addObject("diseases", listOfDiseases);		
		return mav;
	}
	
	@RequestMapping(value = "/maizeStalkDiag", method = RequestMethod.POST)
	public ModelAndView stalkDiagnosis(@Valid MaizeStalkModel msm,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("maizeDiseasesFound");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator itF = l.iterator();
		while (itF.hasNext()) {
			Object o = (Object) itF.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);

		rete = new Rete();
		try {
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\maizestalkdiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(MaizeSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(ShinyStalk (shinyStalk "+ msm.getShinyStalk() + "))");
			rete.assertString("(BlackStalk (blackStalk " + msm.getBlackStalk() + "))");
			rete.assertString("(RottedInternodes (rottedInternodes " + msm.getRottedInternodes() + "))");
			rete.assertString("(BlackDiscoloration (blackDiscoloration "+ msm.getBlackDiscoloration() + "))");
			rete.assertString("(BlackSpecks (blackSpecks "+ msm.getBlackSpecks() + "))");			
			rete.assertString("(ShreddedTissue (shreddedTissue "+ msm.getShreddedTissue() + "))");
			rete.assertString("(VascularBundles (vascularBundles " + msm.getVascularBundles() + "))");
			rete.assertString("(StalkSurface (stalkSurface " + msm.getStalkSurface() + "))");
			rete.assertString("(InfectionSite (infectionSite "+ msm.getInfectionSite() + "))");
			rete.assertString("(TwistedStalk (twistedStalk "+ msm.getTwistedStalk() + "))");			
			rete.assertString("(PinkRootsystem (pinkRootsystem "+ msm.getPinkRootsystem() + "))");
			rete.assertString("(RootMass (rootMass "+ msm.getRootMass() + "))");
						
		} catch (JessException ex) {
			Logger.getLogger(MaizeSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(MaizeSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		List<String> listOfDiseases=new ArrayList<String>();
		float count=0;
		String diagnosis = "";
		try {
			rete.run();
			Iterator it = rete.listFacts();
			Fact faux;

			while (it.hasNext()) {
				faux = (Fact) it.next();
				if (faux.getName().equals("MAIN::Diagnosis")) {
					diagnosis += faux.getSlotValue("diagnosis");
					String withoutQuotes=diagnosis.replace("\"", "");
					listOfDiseases.add(withoutQuotes);
				}
				if (faux.getName().equals("MAIN::ShinyStalk")) {					
					if(faux.getSlotValue("shinyStalk").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BlackStalk")) {					
					if(faux.getSlotValue("blackStalk").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::RottedInternodes")) {									
					if(faux.getSlotValue("rottedInternodes").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BlackDiscoloration")) {										
					if(faux.getSlotValue("blackDiscoloration").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BlackSpecks")) {					
					if(faux.getSlotValue("blackSpecks").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::ShreddedTissue")) {					
					if(faux.getSlotValue("shreddedTissue").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::VascularBundles")) {									
					if(faux.getSlotValue("vascularBundles").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::StalkSurface")) {										
					if(faux.getSlotValue("stalkSurface").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::InfectionSite")) {					
					if(faux.getSlotValue("infectionSite").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::TwistedStalk")) {					
					if(faux.getSlotValue("twistedStalk").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::PinkRootsystem")) {									
					if(faux.getSlotValue("pinkRootsystem").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::RootMass")) {										
					if(faux.getSlotValue("rootMass").equals("yes")){
						count++;
					}						
				}
				
				diagnosis="";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		DecimalFormat fmt=new DecimalFormat("0.##");
		List<String> percentList=new ArrayList<String>();
		float percent=0;
		//begin: calculate percent
		for(int i=0;i<listOfDiseases.size();i++){
		if((listOfDiseases.get(i)).equals("Anthracnose Stalk Rot")){
			percent=(3/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Charcoal Rot")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Diplodia Stalk rot")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Gibberella Stalk rot")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Pythium Stalk rot")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Red Root Rot")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}		
		}
		//end
		
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<listOfDiseases.size();i++){
			map.put(listOfDiseases.get(i), percentList.get(i));
		}
		mav.addObject("count",count);
		request.setAttribute("maps", map);
		
		//mav.addObject("diseases", listOfDiseases);		
		return mav;
	}
}
