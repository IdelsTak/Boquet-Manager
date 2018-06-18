package views.controllers.mainmenu;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class MainMenuController
{

	@FXML
	private Menu menuFile;
	
	@FXML 
	private MenuItem menuItemSaveToXml;
	
	@FXML
	private MenuItem menuItemOpenXml;
	
	@FXML 
	private MenuItem menuItemPreferences;
	
	@FXML
	private MenuItem menuItemQuit;
	
	@FXML
	private Menu menuEdit;
	
	@FXML
	private MenuItem menuItemPaste;
	
	@FXML
	private MenuItem menuItemCopy;
	
	@FXML
	private MenuItem menuItemDelete;
	
	@FXML
	private Menu menuView;
	
	@FXML
	private MenuItem menuItemSortAlphabet;
	
	@FXML
	private MenuItem menuItemSortBySattelites;
		
	@FXML
	private Menu menuLang;
	
	@FXML
	private Menu menuSatReceiver;
	
	@FXML
	private MenuItem menuItemDobx2SatReceiver;
	
	@FXML
	private Menu menuHelp;
	
	@FXML
	private MenuItem menuItemAboutApp;
	
	@FXML
	private MenuItem menuItemAboutAuthors;
	
	@FXML
	private MenuItem menuItemLicense;
	
	@FXML
	private MenuItem menuItemSuppProject;

    @FXML
    private CheckBox chkBoxEng;
    
    @FXML
    private CheckBox chkBoxGer;
    
    @FXML
    private CheckBox chkBoxUkr;
    
    @FXML
    private CheckBox chkBoxRu;

    @FXML
    private MenuItem menuItemEng;
    
    @FXML 
    private MenuItem menuItemGer;
    
    @FXML
    private MenuItem menuItemUkr;
    
    @FXML 
    private MenuItem menuItemRu;
    
	@FXML
	private void initialize()
	{
		chkBoxEng.setOnAction((even) -> {
			selectEngChkBox();
		});

		chkBoxGer.setOnAction((even) -> {
			selectGerChkBox();
		
		});

		chkBoxUkr.setOnAction((even) -> {
			selectUkrChkBox();
		});

		chkBoxRu.setOnAction((even) -> {
			selectRusChkBox();
		});

		menuItemEng.setOnAction((even) -> {
			this.getChkBoxEng().setSelected(true);
			selectEngChkBox();
		});
		
		menuItemGer.setOnAction((even) -> {
			this.getChkBoxGer().setSelected(true);
			selectGerChkBox();
		});
		
		menuItemUkr.setOnAction((even) -> {
			this.getChkBoxUkr().setSelected(true);
			selectUkrChkBox();
		});
		
		menuItemRu.setOnAction((even) -> {
			this.getChkBoxRu().setSelected(true);
			selectRusChkBox();
		});

	}

	private void selectRusChkBox()
	{
		boolean chkBoxRusLangStatus = this.getChkBoxRu().isSelected();
		String lang = "rus";
		selectOnlyOneCheckBox(chkBoxRusLangStatus, lang);
		loadLang(lang);
	}

	private void selectUkrChkBox()
	{
		boolean chkBoxUkrLangStatus = this.getChkBoxUkr().isSelected();
		String lang = "ukr";
		selectOnlyOneCheckBox(chkBoxUkrLangStatus, lang);
		loadLang(lang);
	}

	private void selectGerChkBox()
	{
		boolean chkBoxGerLangStatus = this.getChkBoxGer().isSelected();
		String lang = "ger";
		selectOnlyOneCheckBox(chkBoxGerLangStatus, lang);
		loadLang(lang);
	}

	private void selectEngChkBox()
	{
		boolean chkBoxEngLangStatus = this.getChkBoxEng().isSelected();
		String lang = "eng";
		selectOnlyOneCheckBox(chkBoxEngLangStatus, lang);
		loadLang(lang);
	}

	private void selectOnlyOneCheckBox(boolean chkBoxLangResult, String inputLang)
	{
		switch(inputLang) {
			case "eng":
				if (chkBoxLangResult== true) {
					unselectChkBoxesGerRuUkr();
				}
			break;
			case "ger":
				if (chkBoxLangResult== true) {
					unselectChkBoxesEngRuUkr();
				}
			break;
			case "ukr":
				if (chkBoxLangResult== true) {
					unselectChkBoxesEngRuGer();
				}
			break;
			case "rus":
				if (chkBoxLangResult== true) {
					unselectChkBoxesEngUkrGer();
				}
			break;
		}

	}

	private void loadLang(String inputLang)
	{
		Locale langSelectionLocale;
		switch (inputLang)
		{
			case "ger":
                 langSelectionLocale = new Locale("de","DE");
                 //System.out.println("de gewählt! ");
                 localizeMainMenu(langSelectionLocale);
				break;
			case "eng":
	             langSelectionLocale = new Locale("en","US");
	             //	System.out.println("en gewählt! ");
                 localizeMainMenu(langSelectionLocale);
				break;
			case "ukr":
	             langSelectionLocale = new Locale("uk","UA");
	             // System.out.println("ukr gewählt! ");
                localizeMainMenu(langSelectionLocale);
				break;
			case "rus":
	             langSelectionLocale = new Locale("ru","Ru");
	             //System.out.println("ru gewählt! ");
                localizeMainMenu(langSelectionLocale);
				break;
		}
	}

	private void localizeMainMenu(Locale inputLang)
	{
		 ResourceBundle bundle;
		 //System.out.println(inputLang.toString());
				
		bundle = ResourceBundle.getBundle("internationalization/menu",inputLang);
		 localizeFileMenu(bundle);
		 localizeEditMenu(bundle);
		 localizeViewMenu(bundle);
		 localizeLangMenu(bundle);
		 localizeSatReceiverMenu(bundle);
		 localizeHelpMenu(bundle);
		 
	}

	private void localizeHelpMenu(ResourceBundle bundle)
	{
		this.getMenuHelp().setText(bundle.getString("menuHelp"));
		 this.getMenuItemAboutApp().setText(bundle.getString("HelpItemMenuAboutApp"));
		 this.getMenuItemAboutAuthors().setText(bundle.getString("HelpItemMenuAboutAuthors"));
		 this.getMenuItemLicense().setText(bundle.getString("HelpItemMenuLicense"));
		 this.getMenuItemSuppProject().setText(bundle.getString("HelpItemMenuSupportProject"));
	}

	private void localizeSatReceiverMenu(ResourceBundle bundle)
	{
		this.getMenuSatReceiver().setText(bundle.getString("menuSatReceiver"));
		 this.getMenuItemDobx2SatReceiver().setText(bundle.getString("SatReceiverItemMenuSatReceiver"));
	}

	private void localizeLangMenu(ResourceBundle bundle)
	{
		this.getMenuLang().setText(bundle.getString("menuLang"));
		 this.getMenuItemEng().setText(bundle.getString("LangItemMenuEng"));
		 this.getMenuItemGer().setText(bundle.getString("LangItemMenuGer"));
		 this.getMenuItemUkr().setText(bundle.getString("LangItemMenuUkr"));
		 this.getMenuItemRu().setText(bundle.getString("LangItemMenuRu"));
	}

	private void localizeViewMenu(ResourceBundle bundle)
	{
		this.getMenuView().setText(bundle.getString("menuView"));
		 this.getMenuItemSortAlphabet().setText(bundle.getString("ViewItemMenuSortAlpha"));
		 this.getMenuItemSortBySattelites().setText(bundle.getString("ViewItemMenuSortSat"));
	}

	private void localizeEditMenu(ResourceBundle bundle)
	{
		this.getMenuEdit().setText(bundle.getString("menuEdit"));
		 this.getMenuItemPaste().setText(bundle.getString("EditItemMenuPaste"));
		 this.getMenuItemCopy().setText(bundle.getString("EditItemMenuCopy"));
		 this.getMenuItemDelete().setText(bundle.getString("EditItemMenuDelete"));
	}

	private void localizeFileMenu(ResourceBundle bundle)
	{
		this.getMenuFile().setText(bundle.getString("menuFile"));
		 this.getMenuItemSaveToXml().setText(bundle.getString("FileItemMenuSave"));
		 this.getMenuItemOpenXml().setText(bundle.getString("FileItemMenuOpen"));
		 this.getMenuItemPreferences().setText(bundle.getString("FileItemMenuPreferences"));
		 this.getMenuItemQuit().setText(bundle.getString("FileItemMenuQuit"));
	}

	private void unselectChkBoxesEngUkrGer()
	{
		this.getChkBoxEng().setSelected(false);
		this.getChkBoxUkr().setSelected(false);
		this.getChkBoxGer().setSelected(false);
	}

	private void unselectChkBoxesEngRuGer()
	{
		this.getChkBoxEng().setSelected(false);
		this.getChkBoxRu().setSelected(false);
		this.getChkBoxGer().setSelected(false);
	}

	private void unselectChkBoxesEngRuUkr()
	{
		this.getChkBoxEng().setSelected(false);
		this.getChkBoxRu().setSelected(false);
		this.getChkBoxUkr().setSelected(false);
	}

	private void unselectChkBoxesGerRuUkr()
	{
		this.getChkBoxGer().setSelected(false);
		this.getChkBoxRu().setSelected(false);
		this.getChkBoxUkr().setSelected(false);
	}

	public CheckBox getChkBoxEng()
	{
		return chkBoxEng;
	}

	public void setChkBoxEng(CheckBox chkBoxEng)
	{
		this.chkBoxEng = chkBoxEng;
	}

	public CheckBox getChkBoxGer()
	{
		return chkBoxGer;
	}

	public void setChkBoxGer(CheckBox chkBoxGer)
	{
		this.chkBoxGer = chkBoxGer;
	}

	public CheckBox getChkBoxUkr()
	{
		return chkBoxUkr;
	}

	public void setChkBoxUkr(CheckBox chkBoxUkr)
	{
		this.chkBoxUkr = chkBoxUkr;
	}

	public CheckBox getChkBoxRu()
	{
		return chkBoxRu;
	}

	public void setChkBoxRu(CheckBox chkBoxRu)
	{
		this.chkBoxRu = chkBoxRu;
	}

	public MenuItem getMenuItemEng()
	{
		return menuItemEng;
	}

	public void setMenuItemEng(MenuItem menuItemEng)
	{
		this.menuItemEng = menuItemEng;
	}

	public MenuItem getMenuItemGer()
	{
		return menuItemGer;
	}

	public void setMenuItemGer(MenuItem menuItemGer)
	{
		this.menuItemGer = menuItemGer;
	}

	public MenuItem getMenuItemUkr()
	{
		return menuItemUkr;
	}

	public void setMenuItemUkr(MenuItem menuItemUkr)
	{
		this.menuItemUkr = menuItemUkr;
	}

	public MenuItem getMenuItemRu()
	{
		return menuItemRu;
	}

	public void setMenuItemRu(MenuItem menuItemRu)
	{
		this.menuItemRu = menuItemRu;
	}

	public Menu getMenuFile()
	{
		return menuFile;
	}

	public void setMenuFile(Menu menuFile)
	{
		this.menuFile = menuFile;
	}

	public Menu getMenuEdit()
	{
		return menuEdit;
	}

	public void setMenuEdit(Menu menuEdit)
	{
		this.menuEdit = menuEdit;
	}

	public Menu getMenuView()
	{
		return menuView;
	}

	public void setMenuView(Menu menuView)
	{
		this.menuView = menuView;
	}

	public Menu getMenuLang()
	{
		return menuLang;
	}

	public void setMenuLang(Menu menuLang)
	{
		this.menuLang = menuLang;
	}

	public Menu getMenuSatReceiver()
	{
		return menuSatReceiver;
	}

	public void setMenuSatReceiver(Menu menuSatReceiver)
	{
		this.menuSatReceiver = menuSatReceiver;
	}

	public Menu getMenuHelp()
	{
		return menuHelp;
	}

	public void setMenuHelp(Menu menuHelp)
	{
		this.menuHelp = menuHelp;
	}

	public MenuItem getMenuItemSaveToXml()
	{
		return menuItemSaveToXml;
	}

	public void setMenuItemSaveToXml(MenuItem menuItemSaveToXml)
	{
		this.menuItemSaveToXml = menuItemSaveToXml;
	}

	public MenuItem getMenuItemOpenXml()
	{
		return menuItemOpenXml;
	}

	public void setMenuItemOpenXml(MenuItem menuItemOpenXml)
	{
		this.menuItemOpenXml = menuItemOpenXml;
	}

	public MenuItem getMenuItemPreferences()
	{
		return menuItemPreferences;
	}

	public void setMenuItemPreferences(MenuItem menuItemPreferences)
	{
		this.menuItemPreferences = menuItemPreferences;
	}

	public MenuItem getMenuItemQuit()
	{
		return menuItemQuit;
	}

	public void setMenuItemQuit(MenuItem menuItemQuit)
	{
		this.menuItemQuit = menuItemQuit;
	}

	public MenuItem getMenuItemPaste()
	{
		return menuItemPaste;
	}

	public void setMenuItemPaste(MenuItem menuItemPaste)
	{
		this.menuItemPaste = menuItemPaste;
	}

	public MenuItem getMenuItemCopy()
	{
		return menuItemCopy;
	}

	public void setMenuItemCopy(MenuItem menuItemCopy)
	{
		this.menuItemCopy = menuItemCopy;
	}

	public MenuItem getMenuItemDelete()
	{
		return menuItemDelete;
	}

	public void setMenuItemDelete(MenuItem menuItemDelete)
	{
		this.menuItemDelete = menuItemDelete;
	}

	public MenuItem getMenuItemSortAlphabet()
	{
		return menuItemSortAlphabet;
	}

	public void setMenuItemSortAlphabet(MenuItem menuItemSortAlphabet)
	{
		this.menuItemSortAlphabet = menuItemSortAlphabet;
	}

	public MenuItem getMenuItemSortBySattelites()
	{
		return menuItemSortBySattelites;
	}

	public void setMenuItemSortBySattelites(MenuItem menuItemSortBySattelites)
	{
		this.menuItemSortBySattelites = menuItemSortBySattelites;
	}

	public MenuItem getMenuItemDobx2SatReceiver()
	{
		return menuItemDobx2SatReceiver;
	}

	public void setMenuItemDobx2SatReceiver(MenuItem menuItemDobx2SatReceiver)
	{
		this.menuItemDobx2SatReceiver = menuItemDobx2SatReceiver;
	}

	public MenuItem getMenuItemAboutApp()
	{
		return menuItemAboutApp;
	}

	public void setMenuItemAboutApp(MenuItem menuItemAboutApp)
	{
		this.menuItemAboutApp = menuItemAboutApp;
	}

	public MenuItem getMenuItemAboutAuthors()
	{
		return menuItemAboutAuthors;
	}

	public void setMenuItemAboutAuthors(MenuItem menuItemAboutAuthors)
	{
		this.menuItemAboutAuthors = menuItemAboutAuthors;
	}

	public MenuItem getMenuItemLicense()
	{
		return menuItemLicense;
	}

	public void setMenuItemLicense(MenuItem menuItemLicense)
	{
		this.menuItemLicense = menuItemLicense;
	}

	public MenuItem getMenuItemSuppProject()
	{
		return menuItemSuppProject;
	}

	public void setMenuItemSuppProject(MenuItem menuItemSuppProject)
	{
		this.menuItemSuppProject = menuItemSuppProject;
	}

	
}
