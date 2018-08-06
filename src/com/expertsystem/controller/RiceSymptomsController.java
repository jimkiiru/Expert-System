package com.expertsystem.controller;


import jess.Fact;
import jess.JessException;
import jess.Rete;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
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
public class RiceSymptomsController {

	private static Rete rete;
	
	@Autowired
	SessionFactory factory;
	
	PercentageCount pc=new PercentageCount();
		
	@RequestMapping(value = "/partsaffected", method = RequestMethod.GET)
	public ModelAndView partsAffected(HttpSession session) {
		ModelAndView mav = new ModelAndView("ricePartsAffected");
		
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
	@RequestMapping(value = "/riceDiagResult", method = RequestMethod.GET)
	public ModelAndView diagnosisResult(@RequestParam("listValue")String listValue,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("diagnosisResult");		

		//SessionFactory factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session sess = factory.openSession();

		Query query = sess.createQuery("from RiceDiseaseModel r where r.diseaseName=:diag");
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

	@RequestMapping(value = "/riceleaf", method = RequestMethod.GET)
	public ModelAndView LeafSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("riceLeafSymptoms");
		
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
		
		RiceLeavesModel leaves = new RiceLeavesModel();
		mav.getModelMap().put("riceLeafSymptoms", leaves);
		return mav;
	}

	@RequestMapping(value = "/ricegrain", method = RequestMethod.GET)
	public ModelAndView grainSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("riceGrainSymptoms");
		
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
		
		RiceGrainsModel grain = new RiceGrainsModel();
		mav.getModelMap().put("riceGrainSymptoms", grain);
		return mav;
	}

	@RequestMapping(value = "/riceneck", method = RequestMethod.GET)
	public ModelAndView neckSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("riceNeckSymptoms");
		
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
		
		RiceNeckModel neck = new RiceNeckModel();
		mav.getModelMap().put("riceNeckSymptoms", neck);
		return mav;
	}

	@RequestMapping(value = "/riceroot", method = RequestMethod.GET)
	public ModelAndView rootSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("riceRootsSymptoms");
		
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
		
		RiceRootsModel roots = new RiceRootsModel();
		mav.getModelMap().put("riceRootsSymptoms", roots);
		return mav;
	}

	@RequestMapping(value = "/ricestem", method = RequestMethod.GET)
	public ModelAndView stemSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("riceStemSymtoms");
		
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
		
		RiceStemModel stem = new RiceStemModel();
		mav.getModelMap().put("riceStemSymtoms", stem);
		return mav;
	}

	@RequestMapping(value = "/riceLeafDiag", method = RequestMethod.POST)
	public ModelAndView leafDiagnosis(@Valid RiceLeavesModel rlm,HttpServletRequest request,HttpSession session) {
		
		ModelAndView mav = new ModelAndView("riceDiseasesFound");
		
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
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\riceleavesdiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(RiceSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(Specks (specks "+ rlm.getSpecks() + "))");
			rete.assertString("(Spots (spots " + rlm.getSpots() + "))");
			rete.assertString("(Wilt (wilt " + rlm.getWilt() + "))");
			rete.assertString("(YellowishStripes (yellowishStripes "+ rlm.getYellowishStripes() + "))");
			rete.assertString("(BacterialOoze (bacterialOoze "+ rlm.getBacterialOoze() + "))");			
			rete.assertString("(YellowLessions (yellowLessions "+ rlm.getYellowLessions() + "))");
			rete.assertString("(SheathDiscoloration (sheathDiscoloration " + rlm.getSheathDiscoloration() + "))");
			rete.assertString("(IrregularSpots (irregularSpots " + rlm.getIrregularSpots() + "))");
			rete.assertString("(LesionsEnlarge (lesionsEnlarge "+ rlm.getLesionsEnlarge() + "))");
			rete.assertString("(UnemergedPaniclesrot (unemergedPaniclesrot "+ rlm.getUnemergedPaniclesrot() + "))");			
			rete.assertString("(WhitishPowdery (whitishPowdery "+ rlm.getWhitishPowdery() + "))");
			rete.assertString("(InfectedPaniclesSterile (infectedPaniclesSterile " + rlm.getInfectedPaniclesSterile() + "))");
			rete.assertString("(TranslucentStreaks (translucentStreaks " + rlm.getTranslucentStreaks() + "))");
			rete.assertString("(BrownLesions (brownLesions "+ rlm.getBrownLesions() + "))");
			
		} catch (JessException ex) {
			Logger.getLogger(RiceSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(RiceSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		List<String> listOfDiseases=new ArrayList<String>();
		String diagnosis="";
		float count=0;
		String withoutQuotes="";
		try {
			rete.run();
			Iterator it = rete.listFacts();
			Fact faux;

			while (it.hasNext()) {
				faux = (Fact) it.next();
				if (faux.getName().equals("MAIN::Diagnosis")) {					
					diagnosis += faux.getSlotValue("diagnosis");
					withoutQuotes=diagnosis.replace("\"", "");
					listOfDiseases.add(withoutQuotes);					
				}
				if (faux.getName().equals("MAIN::Specks")) {					
					if(faux.getSlotValue("specks").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::Spots")) {					
					if(faux.getSlotValue("spots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::Wilt")) {									
					if(faux.getSlotValue("wilt").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::YellowishStripes")) {										
					if(faux.getSlotValue("yellowishStripes").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BacterialOoze")) {					
					if(faux.getSlotValue("bacterialOoze").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::YellowLessions")) {					
					if(faux.getSlotValue("yellowLessions").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::SheathDiscoloration")) {									
					if(faux.getSlotValue("sheathDiscoloration").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::IrregularSpots")) {										
					if(faux.getSlotValue("irregularSpots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::LesionsEnlarge")) {					
					if(faux.getSlotValue("lesionsEnlarge").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::UnemergedPaniclesrot")) {					
					if(faux.getSlotValue("unemergedPaniclesrot").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::WhitishPowdery")) {									
					if(faux.getSlotValue("whitishPowdery").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::InfectedPaniclesSterile")) {										
					if(faux.getSlotValue("infectedPaniclesSterile").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::TranslucentStreaks")) {									
					if(faux.getSlotValue("translucentStreaks").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BrownLesions")) {										
					if(faux.getSlotValue("brownLesions").equals("yes")){
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
		if((listOfDiseases.get(i)).equals("Blast")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Bacterial Leaf Blight")){
			percent=(4/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Sheath Rot")){
			percent=(6/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Leaf streak")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Leaf Spot")){
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
		
		return mav;
	}
	
	@RequestMapping(value = "/ricegrainDiag", method = RequestMethod.POST)
	public ModelAndView grainDiagnosis(@Valid RiceGrainsModel rgm,HttpServletRequest request,HttpSession session) {
		
		ModelAndView mav = new ModelAndView("riceDiseasesFound");
		
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
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\ricegrainsdiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(RiceSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(FewGrainsInfected (fewGrainsInfected "+ rgm.getFewGrainsInfected() + "))");
			rete.assertString("(YellowFruiting (yellowFruiting " + rgm.getYellowFruiting() + "))");
			rete.assertString("(VelvetySpores (velvetySpores " + rgm.getVelvetySpores() + "))");
			rete.assertString("(ImmatureSpores (immatureSpores "+ rgm.getImmatureSpores() + "))");
			rete.assertString("(BrokenMembrane (brokenMembrane "+ rgm.getBrokenMembrane() + "))");
			
			rete.assertString("(BlackSpots (blackSpots "+ rgm.getBlackSpots() + "))");
			rete.assertString("(FungalGrowth (fungalGrowth " + rgm.getFungalGrowth() + "))");
		
			
		} catch (JessException ex) {
			Logger.getLogger(RiceSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(RiceSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		String withoutQuotes="";
		float count=0;
		List<String> listOfDiseases=new ArrayList<String>();
		String diagnosis = "";
		try {
			rete.run();
			Iterator it = rete.listFacts();
			Fact faux;

			while (it.hasNext()) {
				faux = (Fact) it.next();
				if (faux.getName().equals("MAIN::Diagnosis")) {
					diagnosis += faux.getSlotValue("diagnosis");
					withoutQuotes=diagnosis.replace("\"", "");
					listOfDiseases.add(withoutQuotes);
				}
				if (faux.getName().equals("MAIN::FewGrainsInfected")) {					
					if(faux.getSlotValue("fewGrainsInfected").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::YellowFruiting")) {					
					if(faux.getSlotValue("yellowFruiting").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::VelvetySpores")) {									
					if(faux.getSlotValue("velvetySpores").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::ImmatureSpores")) {										
					if(faux.getSlotValue("immatureSpores").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BrokenMembrane")) {					
					if(faux.getSlotValue("brokenMembrane").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BlackSpots")) {					
					if(faux.getSlotValue("blackSpots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::FungalGrowth")) {									
					if(faux.getSlotValue("fungalGrowth").equals("yes")){
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
		if((listOfDiseases.get(i)).equals("False Smut")){
			percent=(5/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Grain discoluration")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}				
		}
		//end
		
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<listOfDiseases.size();i++){
			map.put(listOfDiseases.get(i), percentList.get(i));
		}		
		request.setAttribute("maps", map);
		//mav.addObject("count",count);
		//mav.addObject("diseases", listOfDiseases);
		return mav;
	}
	
	@RequestMapping(value = "/riceStemDiag", method = RequestMethod.POST)
	public ModelAndView stemDiagnosis(@Valid RiceStemModel rsm,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("riceDiseasesFound");
		
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
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\ricestemdiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(RiceSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(RectangularLesions (rectangularLesions "+ rsm.getRectangularLesions() + "))");
			rete.assertString("(SheathDie (sheathDie " + rsm.getSheathDie() + "))");
			
			
		} catch (JessException ex) {
			Logger.getLogger(RiceSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(RiceSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		float count=0;
		List<String> listOfDiseases=new ArrayList<String>();
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
				if (faux.getName().equals("MAIN::RectangularLesions")) {					
					if(faux.getSlotValue("rectangularLesions").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::SheathDie")) {					
					if(faux.getSlotValue("sheathDie").equals("yes")){
						count++;
					}						
				}
				diagnosis="";
				/*if (faux.getName().equals("MAIN::Treatment")) {
					treatment += faux.getSlotValue("treatment");
				}*/
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		DecimalFormat fmt=new DecimalFormat("0.##");
		List<String> percentList=new ArrayList<String>();
		float percent=0;
		//begin: calculate percent
		for(int i=0;i<listOfDiseases.size();i++){
		if((listOfDiseases.get(i)).equals("Stem Rot")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Thiophanate Methyl")){
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
		
		/*mav.addObject("count",count);
		mav.addObject("diseases", listOfDiseases);*/
		return mav;
	}
	

	@RequestMapping(value = "/riceRootDiag", method = RequestMethod.POST)
	public ModelAndView rootDiagnosis(@Valid RiceRootsModel rrm,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("riceDiseasesFound");
		
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
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\ricerootdiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(RiceSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(SlowGrowth (slowGrowth "+ rrm.getSlowGrowth() + "))");
			rete.assertString("(YellowLeaves (yellowLeaves " + rrm.getYellowLeaves() + "))");
			rete.assertString("(LeavesDie (leavesDie " + rrm.getLeavesDie() + "))");
			rete.assertString("(DarkRoots (darkRoots "+ rrm.getLimpRoots() + "))");
			rete.assertString("(LimpRoots (limpRoots "+ rrm.getLimpRoots() + "))");
			
		} catch (JessException ex) {
			Logger.getLogger(RiceSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(RiceSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		
		float count=0;
		List<String> listOfDiseases=new ArrayList<String>();
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
				if (faux.getName().equals("MAIN::DarkRoots")) {					
					if(faux.getSlotValue("darkRoots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::LimpRoots")) {									
					if(faux.getSlotValue("limpRoots").equals("yes")){
						count++;
					}						
				}
				diagnosis="";
				/*if (faux.getName().equals("MAIN::Treatment")) {
					treatment += faux.getSlotValue("treatment");
				}*/
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		DecimalFormat fmt=new DecimalFormat("0.##");
		List<String> percentList=new ArrayList<String>();
		float percent=0;
		//begin: calculate percent
		for(int i=0;i<listOfDiseases.size();i++){
		if((listOfDiseases.get(i)).equals("Root Rot")){
			percent=(5/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Fungicide")){
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
		
		/*mav.addObject("count",count);
		mav.addObject("diseases", listOfDiseases);*/
		return mav;
	}
	
	@RequestMapping(value = "/riceNeckDiag", method = RequestMethod.POST)
	public ModelAndView neckDiagnosis(@Valid RiceNeckModel rnm,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("riceDiseasesFound");
		
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
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\riceneckdiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(RiceSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(BlackColor (blackColor "+ rnm.getBlackColor() + "))");
			rete.assertString("(NeckBreaks (neckBreaks " + rnm.getNeckBreaks() + "))");
			
			
		} catch (JessException ex) {
			Logger.getLogger(RiceSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(RiceSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		float count=0;
		List<String> listOfDiseases=new ArrayList<String>();
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
				if (faux.getName().equals("MAIN::BlackColor")) {					
					if(faux.getSlotValue("blackColor").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::NeckBreaks")) {					
					if(faux.getSlotValue("neckBreaks").equals("yes")){
						count++;
					}						
				}
				diagnosis="";
				/*if (faux.getName().equals("MAIN::Treatment")) {
					treatment += faux.getSlotValue("treatment");
				}*/
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		DecimalFormat fmt=new DecimalFormat("0.##");
		List<String> percentList=new ArrayList<String>();
		float percent=0;
		//begin: calculate percent
		for(int i=0;i<listOfDiseases.size();i++){
		if((listOfDiseases.get(i)).equals("Neck Blast")){
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
		
		//mav.addObject("count",count);
		//mav.addObject("diseases", listOfDiseases);
		return mav;
	}
	
}
