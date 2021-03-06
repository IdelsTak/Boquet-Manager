package buildertests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import builders.SatBouquetsBuilder;
import fileutils.ReadXmlAndCreateJdomWithAllBouquets;
import models.SatTvBoquet;

class SatBouquetsBuilderTest
{
	SatBouquetsBuilder satBoquetsBuilderObj;
	
	@BeforeEach
	void setUp()
	{
		satBoquetsBuilderObj = new SatBouquetsBuilder();
	}

	@Test
	void testingIfSatServiceListBuilderObjectExist()
	{
		assertNotNull(satBoquetsBuilderObj);
	}
	
	@Test
	void checkIfBouquetsSetIsNotNullAndBoquetsListCanBeBuild() {
		boolean expectedResult = true;
		boolean actualResult = false;
		String pathToXml = "src//main//resources//XML-Files-Update2018//bouquets.xml";
		
		SortedSet<SatTvBoquet> setOfSortedSatTvBoquets =  new TreeSet<SatTvBoquet>();
		ReadXmlAndCreateJdomWithAllBouquets helperObj =
				new ReadXmlAndCreateJdomWithAllBouquets(pathToXml);
		List<Element> listOfBoquetsJdomElems = new LinkedList<Element>();
		
		try
		{
			helperObj.readAndSetUpJDomDocument();
			listOfBoquetsJdomElems= helperObj.readJdomDocumentAndCreateBouquetsElementList();					
		   setOfSortedSatTvBoquets =satBoquetsBuilderObj.buildSatTvBoquetsSet(
				                                          listOfBoquetsJdomElems
				                                       );
			
			actualResult = checkIfSetOfBoquetsNotEmpty(actualResult, setOfSortedSatTvBoquets);
			
			assertEquals(expectedResult, actualResult,"checking if set of SatTv boquets"
					+ " set can be created");
			
		}catch (ParserConfigurationException | SAXException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean checkIfSetOfBoquetsNotEmpty(boolean actualResult, SortedSet<SatTvBoquet> setOfSortedSatTvBoquets)
	{
		if(setOfSortedSatTvBoquets.isEmpty() == false) {
//		   System.out.println(setOfSortedSatTvBoquets.toString() );
			actualResult = true;
		}else{
			System.out.println("result set has not elements ");
		}
		return actualResult;
	}
	
}
