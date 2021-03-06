package buildertests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import builders.SatTVBoquetChannelsBuilder;
import helperutils.ReadXmlAndCreateJdomWithBoquetTVChannelsList;
import models.SatBoquetTvChannel;


class SatTVBoquetChannelsBuilderTest
{
	SatTVBoquetChannelsBuilder satTvChannelBoquetBuilder;
	List<Element> satTvChannelBoquetList;
	ReadXmlAndCreateJdomWithBoquetTVChannelsList helperObj;
	
	@BeforeEach
	void setUp()
	{
		helperObj = new  ReadXmlAndCreateJdomWithBoquetTVChannelsList();
		satTvChannelBoquetBuilder = new SatTVBoquetChannelsBuilder();
	}

	@Test
	 public void  checkIfSatTVBoquetChannelBuilderIsNotNull(){
		  assertNotNull(satTvChannelBoquetBuilder);
	  }

	@Test
	public void checkIfSatTvChannelListCanBeCreated() {
		List<SatBoquetTvChannel> listOfBoquetTvChannels;
         boolean expectedResult = true;
         boolean actualResult = false;
		try
		{
			helperObj.readAndSetUpJDomDocument();
			satTvChannelBoquetList = helperObj.readJdomDocumentAndCreateSatTvChannelsElementList();
			listOfBoquetTvChannels = satTvChannelBoquetBuilder.buildListOfBoquetSatTvChannels(
					satTvChannelBoquetList);
	//        System.out.println(listOfBoquetTvChannels.toString());		
			actualResult = checkIfResulBoquetChannelsListIsNotEmpty(listOfBoquetTvChannels, actualResult);
			
			assertEquals(expectedResult,actualResult,"checking if sat tv channel List can be created");
			
		}catch (ParserConfigurationException | SAXException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
     }

	private boolean checkIfResulBoquetChannelsListIsNotEmpty(List<SatBoquetTvChannel> listOfBoquetTvChannels,
			boolean actualResult)
	{
		if (listOfBoquetTvChannels.isEmpty() == false) {
			actualResult = true;
		}
		return actualResult;
	}
	
	
	
}