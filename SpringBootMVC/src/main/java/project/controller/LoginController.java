package project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.service.*;
import project.persistence.entities.*;

@Controller
public class LoginController {

	// StringManipulationService stringService;
	UserService userService;
	EventService eventService;
	GroupService groupService;

	// Dependency Injection
	@Autowired
	public LoginController(UserService userService, EventService eventService, GroupService groupService) {
		this.userService = userService;
		this.eventService = eventService;
		this.groupService = groupService;
		
		User birgir = new User("Birgir Orri","birgir","birgir@hi.is");
		User adam = new User("Adam Jens","adam","adam@hi.is");
		User marino = new User("Marino","marino","marino@hi.is");
		User umball = new User("umballreopen", "password123"," bonnykel@hotmail.com");
		User bonnyk = new User("bonnykelvin", "password123", "journeybr@hotmail.com");
		User journe = new User("journeyblakehope", "password123", "alleetypr@hotmail.com");
		User alleet = new User("alleetyped", "password123", "despairir@hotmail.com");
		User despai = new User("despairingflavoured", "password123", "walruspar@hotmail.com");
		User walrus = new User("walruspainter", "password123", "stunnervr@hotmail.com");
		User stunne = new User("stunnervegetarian", "password123", "broadjocr@hotmail.com");
		User broadj = new User("broadjockey", "password123", "hulaquarr@hotmail.com");
		User hulaqu = new User("hulaquarterdeck", "password123", "codingcor@hotmail.com");
		User coding = new User("codingcozy", "password123", "sleautycr@hotmail.com");
		User sleaut = new User("sleautycallaly", "password123", "bruiseunr@hotmail.com");
		User bruise = new User("bruiseungodly", "password123", "alongsidr@hotmail.com");
		User alongs = new User("alongsidebeamer", "password123", "audiwobbr@hotmail.com");
		User audiwo = new User("audiwobble", "password123", "contribur@hotmail.com");
		User contri = new User("contributionbanners", "password123", "gutlesshr@hotmail.com");
		User gutles = new User("gutlessharmful", "password123", "senatorsr@hotmail.com");
		User senato = new User("senatorswin", "password123", "avowroutr@hotmail.com");
		User avowro = new User("avowrouting", "password123", "hilloklar@hotmail.com");
		User hillok = new User("hilloklahoma", "password123", "remarkabr@hotmail.com");
		User remark = new User("remarkablelittle", "password123", "layingspr@hotmail.com");
		User laying = new User("layingspirit", "password123", "phantombr@hotmail.com");
		User phanto = new User("phantombewitched", "password123", "bellacror@hotmail.com");
		User bellac = new User("bellacrobat", "password123", "signsbrir@hotmail.com");
		User signsb = new User("signsbriefcase", "password123", "hacksawmr@hotmail.com");
		User hacksa = new User("hacksawmoonshine", "password123", "examshowr@hotmail.com");
		User examsh = new User("examshowy", "password123", "caviermar@hotmail.com");
		User cavier = new User("caviermartin", "password123", "nemocolor@hotmail.com");
		User nemoco = new User("nemocolourless", "password123", "snorkelcr@hotmail.com");
		User snorke = new User("snorkelcriticize", "password123", "pecanexcr@hotmail.com");
		User pecane = new User("pecanexcuse", "password123", "followinr@hotmail.com");
		User follow = new User("followingshopper", "password123", "towermixr@hotmail.com");
		User towerm = new User("towermixture", "password123", "steadypar@hotmail.com");
		User steady = new User("steadypastebin", "password123", "sedatenor@hotmail.com");
		User sedate = new User("sedatenon", "password123", "snowinesr@hotmail.com");
		User snowin = new User("snowinesseye", "password123", "normanjor@hotmail.com");
		User norman = new User("normanjoyous", "password123", "gustynorr@hotmail.com");
		User gustyn = new User("gustynorma", "password123", "moristonr@hotmail.com");
		User morist = new User("moristonsignpost", "password123", "devonposr@hotmail.com");
		User devonp = new User("devonposh", "password123", "hedgingpr@hotmail.com");
		User hedgin = new User("hedgingproxy", "password123", "maeparenr@hotmail.com");
		User maepar = new User("maeparents", "password123", "crepesper@hotmail.com");
		User crepes = new User("crepespew", "password123", "finartfor@hotmail.com");
		User finart = new User("finartforsa", "password123", "countappr@hotmail.com");
		User counta = new User("countapproval", "password123", "bungfangr@hotmail.com");
		User bungfa = new User("bungfang", "password123", "genuinerr@hotmail.com");
		User genuin = new User("genuinereputably", "password123", "origintar@hotmail.com");
		User origin = new User("origintaxonomy", "password123", "jerrypror@hotmail.com");
		User jerryp = new User("jerryprodigal", "password123", "sugarsopr@hotmail.com");
		User sugars = new User("sugarsophronia", "password123", "ziplipstr@hotmail.com");
		User ziplip = new User("ziplipstick", "password123", "battalior@hotmail.com");
		User battal = new User("battalionbanker", "password123", "argybargr@hotmail.com");
		User argyba = new User("argybargyrecycling", "password123", "appreciar@hotmail.com");
		User apprec = new User("appreciatedeficient", "password123", "arrowhear@hotmail.com");
		User arrowh = new User("arrowheadshumping", "password123", "planeappr@hotmail.com");
		User planea = new User("planeapproval", "password123", "wortyplar@hotmail.com");
		User wortyp = new User("wortyplaytime", "password123", "guideawar@hotmail.com");
		User guidea = new User("guideaward", "password123", "groovingr@hotmail.com");
		User groovi = new User("groovingcows", "password123", "expanddrr@hotmail.com");
		User expand = new User("expanddribbling", "password123", "husheddir@hotmail.com");
		User hushed = new User("husheddisregard", "password123", "stingrayr@hotmail.com");
		User stingr = new User("stingrayjag", "password123", "cozinessr@hotmail.com");
		User cozine = new User("cozinessmateo", "password123", "scrambler@hotmail.com");
		User scramb = new User("scramblerepona", "password123", "belleratr@hotmail.com");
		User beller = new User("belleratio", "password123", "sinkantlr@hotmail.com");
		User sinkan = new User("sinkantler", "password123", "specimenr@hotmail.com");
		User specim = new User("specimendomestic", "password123", "brushwanr@hotmail.com");
		User brushw = new User("brushwandought", "password123", "outspoker@hotmail.com");
		User outspo = new User("outspokenplane", "password123", "jokinglyr@hotmail.com");
		User joking = new User("jokinglysample", "password123", "gidgetthr@hotmail.com");
		User gidget = new User("gidgetthurso", "password123", "payphoner@hotmail.com");
		User paypho = new User("payphonetony", "password123", "quartiler@gmail.com");
		User quarti = new User("quartilestinchar", "password123", "gogglessr@gmail.com");
		User goggle = new User("gogglesshove", "password123", "dumplongr@gmail.com");
		User dumplo = new User("dumplongfellow", "password123", "cohesiver@gmail.com");
		User cohesi = new User("cohesivefraser", "password123", "fieldramr@gmail.com");
		User fieldr = new User("fieldramb", "password123", "futureanr@gmail.com");
		User future = new User("futureanalysis", "password123", "ceilgrasr@gmail.com");
		User ceilgr = new User("ceilgrasp", "password123", "rackmeasr@gmail.com");
		User rackme = new User("rackmeasle", "password123", "kivafuner@gmail.com");
		User kivafu = new User("kivafuneral", "password123", "objectivr@gmail.com");
		User object = new User("objectivekenzi", "password123", "silversir@gmail.com");
		User silver = new User("silversialoquent", "password123", "deanfiscr@gmail.com");
		User deanfi = new User("deanfiscally", "password123", "priedrecr@gmail.com");
		User priedr = new User("priedrecast", "password123", "joggingjr@gmail.com");
		User joggin = new User("joggingjackson", "password123", "supperenr@gmail.com");
		User supper = new User("supperengine", "password123", "richnessr@gmail.com");
		User richne = new User("richnessdominique", "password123", "retaininr@gmail.com");
		User retain = new User("retainingcoaching", "password123", "conditior@gmail.com");
		User condit = new User("conditionpeach", "password123", "thesisthr@gmail.com");
		User thesis = new User("thesistherapist", "password123", "sdraughtr@gmail.com");
		User sdraug = new User("sdraughtdelirium", "password123", "thoroughr@gmail.com");
		User thorou = new User("thoroughsqueak", "password123", "treadmilr@gmail.com");
		User treadm = new User("treadmillsample", "password123", "delicacyr@gmail.com");
		User delica = new User("delicacyshadily", "password123", "trolleybr@gmail.com");
		User trolle = new User("trolleybusserjeant", "password123", "riderspor@gmail.com");
		User riders = new User("ridersport", "password123", "attemptor@gmail.com");
		User attemp = new User("attemptomissible", "password123", "slabsimmr@gmail.com");
		User slabsi = new User("slabsimmonds", "password123", "foggyimpr@gmail.com");
		User foggyi = new User("foggyimproving", "password123", "holystonr@gmail.com");
		User holyst = new User("holystonestylus", "password123", "busdatinr@gmail.com");
		User busdat = new User("busdating", "password123", "whinesetr@gmail.com");
		User whines = new User("whinesethimble", "password123", "clyindivr@gmail.com");
		User clyind = new User("clyindividual", "password123", "volleyamr@gmail.com");
		User volley = new User("volleyamazingly", "password123", "ogmoreamr@gmail.com");
		User ogmore = new User("ogmoreambush", "password123", "knitsever@gmail.com");
		User knitse = new User("knitseverity", "password123", "gurukrypr@gmail.com");
		User gurukr = new User("gurukrypton", "password123", "revelatir@gmail.com");
		User revela = new User("revelationunreeve", "password123", "antimonyr@gmail.com");
		User antimo = new User("antimonygem", "password123", "duchessqr@gmail.com");
		User duches = new User("duchessquickest", "password123", "linkedlir@gmail.com");
		User linked = new User("linkedlifting", "password123", "flaprewar@gmail.com");
		User flapre = new User("flapreward", "password123", "crakepacr@gmail.com");
		User crakep = new User("crakepacked", "password123", "pipetzoor@gmail.com");
		User pipetz = new User("pipetzoologist", "password123", "halfeaser@gmail.com");
		User halfea = new User("halfeasel", "password123", "ulcersanr@gmail.com");
		User ulcers = new User("ulcersangellist", "password123", "sunburnvr@gmail.com");
		User sunbur = new User("sunburnvehicle", "password123", "delicater@gmail.com");
		User delica1 = new User("delicatechisholm", "password123", "buttercrr@gmail.com");
		User butter = new User("buttercreamchoice", "password123", "signorror@gmail.com");
		User signor = new User("signorrocket", "password123", "tauntshir@gmail.com");
		User taunts = new User("tauntshivering", "password123", "venusfoar@gmail.com");
		User venusf = new User("venusfoal", "password123", "cambridgr@gmail.com");
		User cambri = new User("cambridgelavender", "password123", "deletionr@gmail.com");
		User deleti = new User("deletionbearnaise", "password123", "chillmatr@gmail.com");
		User chillm = new User("chillmatter", "password123", "completer@gmail.com");
		User comple = new User("completestalwart", "password123", "untoldcor@gmail.com");
		User untold = new User("untoldcost", "password123", "sheriffdr@gmail.com");
		User sherif = new User("sheriffdozed", "password123", "slorwardr@gmail.com");
		User slorwa = new User("slorwardbuzz", "password123", "sierrainr@gmail.com");
		User sierra = new User("sierrainclude", "password123", "baffleslr@gmail.com");
		User baffle = new User("baffleslap", "password123", "supermanr@gmail.com");
		User superm = new User("supermanstaff", "password123", "shawdoner@gmail.com");
		User shawdo = new User("shawdonedge", "password123", "eridanusr@gmail.com");
		User eridan = new User("eridanusgloater", "password123", "utahbroor@gmail.com");
		User utahbr = new User("utahbrooklyn", "password123", "bramleylr@hotmail.com");
		User bramle = new User("bramleylola", "password123", "savedcoar@msn.com");
		User savedc = new User("savedcoat", "password123", "trooppasr@msn.com");
		User troopp = new User("trooppassed", "password123", "prefercur@msn.com");
		User prefer = new User("prefercurtsy", "password123", "stirsnusr@msn.com");
		User stirsn = new User("stirsnushy", "password123", "snazzyhur@msn.com");
		User snazzy = new User("snazzyhushroom", "password123", "graphguir@msn.com");
		User graphg = new User("graphguide", "password123", "eachpeatr@msn.com");
		User eachpe = new User("eachpeated", "password123", "headfirsr@msn.com");
		User headfi = new User("headfirstroulette", "password123", "congeniar@msn.com");
		User congen = new User("congenialcello", "password123", "swooshler@msn.com");
		User swoosh = new User("swooshlethargic", "password123", "excavator@msn.com");
		User excava = new User("excavatorshank", "password123", "disarmmor@msn.com");
		User disarm = new User("disarmmost", "password123", "winnerser@msn.com");
		User winner = new User("winnersenator", "password123", "wingrearr@msn.com");
		User wingre = new User("wingrearview", "password123", "wombatgar@msn.com");
		User wombat = new User("wombatgarage", "password123", "cageygolr@msn.com");
		User cageyg = new User("cageygolf", "password123", "snizortor@msn.com");
		User snizor = new User("snizortopengl", "password123", "nylonsurr@msn.com");
		User nylons = new User("nylonsurd", "password123", "turnipscr@msn.com");
		User turnip = new User("turnipscratch", "password123", "blatancyr@msn.com");
		User blatan = new User("blatancymarkham", "password123", "diligentr@msn.com");
		User dilige = new User("diligentshindig", "password123", "ascensior@msn.com");
		User ascens = new User("ascensionsquire", "password123", "foundergr@msn.com");
		User founde = new User("foundergit", "password123", "outrigger@msn.com");
		User outrig = new User("outriggerplural", "password123", "alkaliner@msn.com");
		User alkali = new User("alkalinesuck", "password123", "scoutafrr@msn.com");
		User scouta = new User("scoutafrican", "password123", "unchinbrr@msn.com");
		User unchin = new User("unchinbrennand", "password123", "couldcanr@msn.com");
		User couldc = new User("couldcanning", "password123", "footagecr@msn.com");
		User footag = new User("footagecavernous", "password123", "knutterbr@msn.com");
		User knutte = new User("knutterbased", "password123", "apricotsr@msn.com");
		User aprico = new User("apricotsdressage", "password123", "weenierer@msn.com");
		User weenie = new User("weeniereliably", "password123", "ankarabar@msn.com");
		User ankara = new User("ankarabarr", "password123", "paellaorr@msn.com");
		User paella = new User("paellaorchy", "password123", "batmancrr@msn.com");
		User batman = new User("batmancrewmember", "password123", "directerr@msn.com");
		User direct = new User("directerased", "password123", "fruitfinr@msn.com");
		User fruitf = new User("fruitfinance", "password123", "deceitskr@msn.com");
		User deceit = new User("deceitskimpily", "password123", "learnedsr@msn.com");
		User learne = new User("learnedspur", "password123", "yendisapr@msn.com");
		User yendis = new User("yendisappointed", "password123", "disasterr@msn.com");
		User disast = new User("disasterdrinking", "password123", "zombieyer@msn.com");
		User zombie = new User("zombieyear", "password123", "coupaller@msn.com");
		User coupal = new User("coupallearing", "password123", "scroorspr@msn.com");
		User scroor = new User("scroorsprawl", "password123", "scopeodir@msn.com");
		User scopeo = new User("scopeodiferous", "password123", "smallweer@msn.com");
		User smallw = new User("smallweedrights", "password123", "shannonpr@msn.com");
		User shanno = new User("shannonprotest", "password123", "sphericar@msn.com");
		User spheri = new User("sphericalperfume", "password123", "locksfeer@msn.com");
		User locksf = new User("locksfeedback", "password123", "siftcollr@msn.com");
		User siftco = new User("siftcollide", "password123", "finchfrer@msn.com");
		User finchf = new User("finchfreedom", "password123", "maddancir@msn.com");
		User maddan = new User("maddancing", "password123", "numbingar@msn.com");
		User numbin = new User("numbingandromeda", "password123", "shotcounr@msn.com");
		User shotco = new User("shotcountless", "password123", "reformisr@msn.com");
		User reform = new User("reformistsky", "password123", "maskedror@msn.com");
		User masked = new User("maskedroman", "password123", "haltingdr@msn.com");
		User haltin = new User("haltingdream", "password123", "jaggedslr@msn.com");
		User jagged = new User("jaggedslushy", "password123", "baziloutr@msn.com");
		User bazilo = new User("baziloutmatch", "password123", "synergytr@msn.com");
		User synerg = new User("synergytrapping", "password123", "crisparkr@msn.com");
		User crispa = new User("crisparklekindle", "password123", "overlyinr@msn.com");
		User overly = new User("overlyingbeatrice", "password123", "kittybagr@msn.com");
		User kittyb = new User("kittybagpipe", "password123", "wickchlor@msn.com");
		User wickch = new User("wickchlorine", "password123", "sakkattakk@live.co.uk");
		userService.createUser(umball);
		userService.createUser(bonnyk);
		userService.createUser(journe);
		userService.createUser(alleet);
		userService.createUser(despai);
		userService.createUser(walrus);
		userService.createUser(stunne);
		userService.createUser(broadj);
		userService.createUser(hulaqu);
		userService.createUser(coding);
		userService.createUser(sleaut);
		userService.createUser(bruise);
		userService.createUser(alongs);
		userService.createUser(audiwo);
		userService.createUser(contri);
		userService.createUser(gutles);
		userService.createUser(senato);
		userService.createUser(avowro);
		userService.createUser(hillok);
		userService.createUser(remark);
		userService.createUser(laying);
		userService.createUser(phanto);
		userService.createUser(bellac);
		userService.createUser(signsb);
		userService.createUser(hacksa);
		userService.createUser(examsh);
		userService.createUser(cavier);
		userService.createUser(nemoco);
		userService.createUser(snorke);
		userService.createUser(pecane);
		userService.createUser(follow);
		userService.createUser(towerm);
		userService.createUser(steady);
		userService.createUser(sedate);
		userService.createUser(snowin);
		userService.createUser(norman);
		userService.createUser(gustyn);
		userService.createUser(morist);
		userService.createUser(devonp);
		userService.createUser(hedgin);
		userService.createUser(maepar);
		userService.createUser(crepes);
		userService.createUser(finart);
		userService.createUser(counta);
		userService.createUser(bungfa);
		userService.createUser(genuin);
		userService.createUser(origin);
		userService.createUser(jerryp);
		userService.createUser(sugars);
		userService.createUser(ziplip);
		userService.createUser(battal);
		userService.createUser(argyba);
		userService.createUser(apprec);
		userService.createUser(arrowh);
		userService.createUser(planea);
		userService.createUser(wortyp);
		userService.createUser(guidea);
		userService.createUser(groovi);
		userService.createUser(expand);
		userService.createUser(hushed);
		userService.createUser(stingr);
		userService.createUser(cozine);
		userService.createUser(scramb);
		userService.createUser(beller);
		userService.createUser(sinkan);
		userService.createUser(specim);
		userService.createUser(brushw);
		userService.createUser(outspo);
		userService.createUser(joking);
		userService.createUser(gidget);
		userService.createUser(paypho);
		userService.createUser(quarti);
		userService.createUser(goggle);
		userService.createUser(dumplo);
		userService.createUser(cohesi);
		userService.createUser(fieldr);
		userService.createUser(future);
		userService.createUser(ceilgr);
		userService.createUser(rackme);
		userService.createUser(kivafu);
		userService.createUser(object);
		userService.createUser(silver);
		userService.createUser(deanfi);
		userService.createUser(priedr);
		userService.createUser(joggin);
		userService.createUser(supper);
		userService.createUser(richne);
		userService.createUser(retain);
		userService.createUser(condit);
		userService.createUser(thesis);
		userService.createUser(sdraug);
		userService.createUser(thorou);
		userService.createUser(treadm);
		userService.createUser(delica);
		userService.createUser(trolle);
		userService.createUser(riders);
		userService.createUser(attemp);
		userService.createUser(slabsi);
		userService.createUser(foggyi);
		userService.createUser(holyst);
		userService.createUser(busdat);
		userService.createUser(whines);
		userService.createUser(clyind);
		userService.createUser(volley);
		userService.createUser(ogmore);
		userService.createUser(knitse);
		userService.createUser(gurukr);
		userService.createUser(revela);
		userService.createUser(antimo);
		userService.createUser(duches);
		userService.createUser(linked);
		userService.createUser(flapre);
		userService.createUser(crakep);
		userService.createUser(pipetz);
		userService.createUser(halfea);
		userService.createUser(ulcers);
		userService.createUser(sunbur);
		userService.createUser(delica1);
		userService.createUser(butter);
		userService.createUser(signor);
		userService.createUser(taunts);
		userService.createUser(venusf);
		userService.createUser(cambri);
		userService.createUser(deleti);
		userService.createUser(chillm);
		userService.createUser(comple);
		userService.createUser(untold);
		userService.createUser(sherif);
		userService.createUser(slorwa);
		userService.createUser(sierra);
		userService.createUser(baffle);
		userService.createUser(superm);
		userService.createUser(shawdo);
		userService.createUser(eridan);
		userService.createUser(utahbr);
		userService.createUser(bramle);
		userService.createUser(savedc);
		userService.createUser(troopp);
		userService.createUser(prefer);
		userService.createUser(stirsn);
		userService.createUser(snazzy);
		userService.createUser(graphg);
		userService.createUser(eachpe);
		userService.createUser(headfi);
		userService.createUser(congen);
		userService.createUser(swoosh);
		userService.createUser(excava);
		userService.createUser(disarm);
		userService.createUser(winner);
		userService.createUser(wingre);
		userService.createUser(wombat);
		userService.createUser(cageyg);
		userService.createUser(snizor);
		userService.createUser(nylons);
		userService.createUser(turnip);
		userService.createUser(blatan);
		userService.createUser(dilige);
		userService.createUser(ascens);
		userService.createUser(founde);
		userService.createUser(outrig);
		userService.createUser(alkali);
		userService.createUser(scouta);
		userService.createUser(unchin);
		userService.createUser(couldc);
		userService.createUser(footag);
		userService.createUser(knutte);
		userService.createUser(aprico);
		userService.createUser(weenie);
		userService.createUser(ankara);
		userService.createUser(paella);
		userService.createUser(batman);
		userService.createUser(direct);
		userService.createUser(fruitf);
		userService.createUser(deceit);
		userService.createUser(learne);
		userService.createUser(yendis);
		userService.createUser(disast);
		userService.createUser(zombie);
		userService.createUser(coupal);
		userService.createUser(scroor);
		userService.createUser(scopeo);
		userService.createUser(smallw);
		userService.createUser(shanno);
		userService.createUser(spheri);
		userService.createUser(locksf);
		userService.createUser(siftco);
		userService.createUser(finchf);
		userService.createUser(maddan);
		userService.createUser(numbin);
		userService.createUser(shotco);
		userService.createUser(reform);
		userService.createUser(masked);
		userService.createUser(haltin);
		userService.createUser(jagged);
		userService.createUser(bazilo);
		userService.createUser(synerg);
		userService.createUser(crispa);
		userService.createUser(overly);
		userService.createUser(kittyb);
		userService.createUser(wickch);
		userService.createUser(birgir);
		userService.createUser(adam);
		userService.createUser(marino);
		
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String createNewUser(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("email") String email, 
			@RequestParam("password1") String password1) {
		
		if(username == null || password == null || email == null || password1 == null) {
				model.addAttribute("errorMsg1", "VILLA MAÐUR! try again");
				return "Index";
		} else {
				if(password.equals(password1)){
				if(!userService.findAllUsers().contains(userService.findByEmail(email))) {
					User newUser = new User(username, password, email);
					userService.createUser(newUser);
				}
				
				return "Index";
			} else {
				model.addAttribute("errorMsg1", "VILLA MAÐUR! try again");
				return "Index";
			}
		}
		
	}

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String validLogin(@RequestParam("email") String email, @RequestParam("password") String password, 
			Model model) {

		User login_user = userService.findByEmail(email);
		
		if(login_user != null) {
			if (login_user.getPassword().equals(password)) {
				
				userService.setCurrentUser(login_user);
				User currentUser = userService.getCurrentUser();
				List<Event> allEvents = eventService.findAllEvents();
				List<Event> show1 = new ArrayList<Event>();
				
				for(Event e: allEvents) {
					if(e.getGroupID() < 1) {
						show1.add(e);
					} else {
						System.out.println("getting group");
						Group g = groupService.findGroupByID(e.getGroupID());
						System.out.println("group gotten");
						if(!(g.getMembers().isEmpty())) {
							if(g.getMembers().contains(currentUser.getEmail())) {
								System.out.println("adding to show");
								show1.add(e);
								System.out.println("added");
							}
						}
					}
				}
				
				model.addAttribute("eventList", show1 );
				return "Events";
			} else {
				model.addAttribute("errorMsg", "VILLA MAÐUR! try again");
				return "Index";
			}
		} else {
			model.addAttribute("errorMsg", "VILLA MAÐUR! try again");
			return "Index";
		}
	}
	
	@RequestMapping(value = "/GuestUser", method = RequestMethod.GET)
	public String GuestSignIn(Model model) {
		User Guest = new User("guest","guest","guest@email.is");
		userService.createUser(Guest);
		userService.setCurrentUser(Guest);
		
		//userService.setCurrentUser(login_user);
		User currentUser = userService.getCurrentUser();
		List<Event> allEvents = eventService.findAllEvents();
		List<Event> show2 = new ArrayList<Event>();
		
		for(Event e: allEvents) {
			if(e.getGroupID() < 1) {
				show2.add(e);
			} else {
				System.out.println("getting group");
				Group g = groupService.findGroupByID(e.getGroupID());
				System.out.println("group gotten");
				if(!(g.getMembers().isEmpty())) {
					if(g.getMembers().contains(currentUser.getEmail())) {
						System.out.println("adding to show");
						show2.add(e);
						System.out.println("added");
					}
				}
			}
		}
		
		model.addAttribute("eventList", show2 );
		
		return "Events";
	}
}