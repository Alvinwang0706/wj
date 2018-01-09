package cn.com.sinosoft.util;

import cn.com.sinosoft.bean.PresentConfig;
import cn.com.sinosoft.bean.SystemConfig;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 工具类 - 礼品相关配置
 * ============================================================================
 *  
 *
 *  
 *
 *  
 *
 * KEY:SINOSOFT6A15A4BF2AF0A65F46FF20145368F1F4
 * ============================================================================
 */

public class PresentConfigUtil {
	private static final Logger logger = LoggerFactory.getLogger(PresentConfigUtil.class);

	public static final String CONFIG_FILE_NAME = "sinosoft.xml";// 系统配置文件名称
	public static final String PRESENT_CONFIG_CACHE_KEY = "presentConfig";// systemConfig缓存Key

	/**
	 * 获取系统配置信息
	 * 
	 * @return SystemConfig对象
	 */
	public static PresentConfig getPresentConfig() {
		PresentConfig systemConfig = (PresentConfig) OsCacheConfigUtil.getFromCache(PRESENT_CONFIG_CACHE_KEY);
		if (systemConfig != null) {
			return systemConfig;
		}
		File configFile = null;
		Document document = null;
		try {
			String configFilePath = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath() + CONFIG_FILE_NAME;
			configFile = new File(configFilePath);
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(configFile);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		Node systemNameNode = document.selectSingleNode("/shop/systemConfig/systemName");
		Node systemVersionNode = document.selectSingleNode("/shop/systemConfig/systemVersion");
		Node systemDescriptionNode = document.selectSingleNode("/shop/systemConfig/systemDescription");
		Node isInstalledNode = document.selectSingleNode("/shop/systemConfig/isInstalled");
		Node shopNameNode = document.selectSingleNode("/shop/systemConfig/shopName");
		Node shopUrlNode = document.selectSingleNode("/shop/systemConfig/shopUrl");
		Node shopLogoNode = document.selectSingleNode("/shop/systemConfig/shopLogo");
		Node hotSearchNode = document.selectSingleNode("/shop/systemConfig/hotSearch");
		Node metaKeywordsNode = document.selectSingleNode("/shop/systemConfig/metaKeywords");
		Node metaDescriptionNode = document.selectSingleNode("/shop/systemConfig/metaDescription");
		Node addressNode = document.selectSingleNode("/shop/systemConfig/address");
		Node phoneNode = document.selectSingleNode("/shop/systemConfig/phone");
		Node zipCodeNode = document.selectSingleNode("/shop/systemConfig/zipCode");
		Node emailNode = document.selectSingleNode("/shop/systemConfig/email");
		Node currencyTypeNode = document.selectSingleNode("/shop/systemConfig/currencyType");
		Node currencySignNode = document.selectSingleNode("/shop/systemConfig/currencySign");
		Node currencyUnitNode = document.selectSingleNode("/shop/systemConfig/currencyUnit");
		Node priceScaleNode = document.selectSingleNode("/shop/systemConfig/priceScale");
		Node priceRoundTypeNode = document.selectSingleNode("/shop/systemConfig/priceRoundType");
		Node orderScaleNode = document.selectSingleNode("/shop/systemConfig/orderScale");
		Node orderRoundTypeNode = document.selectSingleNode("/shop/systemConfig/orderRoundType");
		Node certtextNode = document.selectSingleNode("/shop/systemConfig/certtext");
		Node storeAlertCountNode = document.selectSingleNode("/shop/systemConfig/storeAlertCount");
		Node storeFreezeTimeNode = document.selectSingleNode("/shop/systemConfig/storeFreezeTime");
		Node uploadLimitNode = document.selectSingleNode("/shop/systemConfig/uploadLimit");
		Node isLoginFailureLockNode = document.selectSingleNode("/shop/systemConfig/isLoginFailureLock");
		Node loginFailureLockCountNode = document.selectSingleNode("/shop/systemConfig/loginFailureLockCount");
		Node loginFailureLockTimeNode = document.selectSingleNode("/shop/systemConfig/loginFailureLockTime");
		Node isRegisterNode = document.selectSingleNode("/shop/systemConfig/isRegister");
		Node watermarkImagePathNode = document.selectSingleNode("/shop/systemConfig/watermarkImagePath");
		Node watermarkPositionNode = document.selectSingleNode("/shop/systemConfig/watermarkPosition");
		Node watermarkAlphaNode = document.selectSingleNode("/shop/systemConfig/watermarkAlpha");
		Node bigProductImageWidthNode = document.selectSingleNode("/shop/systemConfig/bigProductImageWidth");
		Node bigProductImageHeightNode = document.selectSingleNode("/shop/systemConfig/bigProductImageHeight");
		Node smallProductImageWidthNode = document.selectSingleNode("/shop/systemConfig/smallProductImageWidth");
		Node smallProductImageHeightNode = document.selectSingleNode("/shop/systemConfig/smallProductImageHeight");
		Node thumbnailProductImageWidthNode = document.selectSingleNode("/shop/systemConfig/thumbnailProductImageWidth");
		Node thumbnailProductImageHeightNode = document.selectSingleNode("/shop/systemConfig/thumbnailProductImageHeight");
		Node defaultBigProductImagePathNode = document.selectSingleNode("/shop/systemConfig/defaultBigProductImagePath");
		Node defaultSmallProductImagePathNode = document.selectSingleNode("/shop/systemConfig/defaultSmallProductImagePath");
		Node defaultThumbnailProductImagePathNode = document.selectSingleNode("/shop/systemConfig/defaultThumbnailProductImagePath");
		Node allowedUploadImageExtensionNode = document.selectSingleNode("/shop/systemConfig/allowedUploadImageExtension");
		Node allowedUploadMediaExtensionNode = document.selectSingleNode("/shop/systemConfig/allowedUploadMediaExtension");
		Node allowedUploadFileExtensionNode = document.selectSingleNode("/shop/systemConfig/allowedUploadFileExtension");
		Node smtpFromMailNode = document.selectSingleNode("/shop/systemConfig/smtpFromMail");
		Node smtpHostNode = document.selectSingleNode("/shop/systemConfig/smtpHost");
		Node smtpPortNode = document.selectSingleNode("/shop/systemConfig/smtpPort");
		Node smtpUsernameNode = document.selectSingleNode("/shop/systemConfig/smtpUsername");
		Node smtpPasswordNode = document.selectSingleNode("/shop/systemConfig/smtpPassword");
		Node pointTypeNode = document.selectSingleNode("/shop/systemConfig/pointType");
		Node pointScaleNode = document.selectSingleNode("/shop/systemConfig/pointScale");
		
		Node bigPresentImageWidthNode = document.selectSingleNode("/shop/systemConfig/bigPresentImageWidth");
		Node bigPresentImageHeightNode = document.selectSingleNode("/shop/systemConfig/bigPresentImageHeight");
		Node smallPresentImageWidthNode = document.selectSingleNode("/shop/systemConfig/smallPresentImageWidth");
		Node smallPresentImageHeightNode = document.selectSingleNode("/shop/systemConfig/smallPresentImageHeight");
		Node thumbnailPresentImageWidthNode = document.selectSingleNode("/shop/systemConfig/thumbnailPresentImageWidth");
		Node thumbnailPresentImageHeightNode = document.selectSingleNode("/shop/systemConfig/thumbnailPresentImageHeight");
		Node defaultBigPresentImagePathNode = document.selectSingleNode("/shop/systemConfig/defaultBigPresentImagePath");
		Node defaultSmallPresentImagePathNode = document.selectSingleNode("/shop/systemConfig/defaultSmallPresentImagePath");
		Node defaultThumbnailPresentImagePathNode = document.selectSingleNode("/shop/systemConfig/defaultThumbnailPresentImagePath");
		
		systemConfig = new PresentConfig();
		systemConfig.setSystemName(systemNameNode.getText());
		systemConfig.setSystemVersion(systemVersionNode.getText());
		systemConfig.setSystemDescription(systemDescriptionNode.getText());
		systemConfig.setIsInstalled(Boolean.valueOf(isInstalledNode.getText()));
		systemConfig.setShopName(shopNameNode.getText());
		systemConfig.setShopUrl(shopUrlNode.getText());
		systemConfig.setShopLogo(shopLogoNode.getText());
		systemConfig.setHotSearch(hotSearchNode.getText());
		systemConfig.setMetaKeywords(metaKeywordsNode.getText());
		systemConfig.setMetaDescription(metaDescriptionNode.getText());
		systemConfig.setAddress(addressNode.getText());
		systemConfig.setPhone(phoneNode.getText());
		systemConfig.setZipCode(zipCodeNode.getText());
		systemConfig.setEmail(emailNode.getText());
		systemConfig.setPriceScale(Integer.valueOf(priceScaleNode.getText()));
		systemConfig.setOrderScale(Integer.valueOf(orderScaleNode.getText()));
		systemConfig.setCerttext(certtextNode.getText());
		systemConfig.setStoreAlertCount(Integer.valueOf(storeAlertCountNode.getText()));
		systemConfig.setUploadLimit(Integer.valueOf(uploadLimitNode.getText()));
		systemConfig.setIsLoginFailureLock(Boolean.valueOf(isLoginFailureLockNode.getText()));
		systemConfig.setLoginFailureLockCount(Integer.valueOf(loginFailureLockCountNode.getText()));
		systemConfig.setLoginFailureLockTime(Integer.valueOf(loginFailureLockTimeNode.getText()));
		systemConfig.setIsRegister(Boolean.valueOf(isRegisterNode.getText()));
		systemConfig.setWatermarkImagePath(watermarkImagePathNode.getText());
		systemConfig.setWatermarkAlpha(Integer.valueOf(watermarkAlphaNode.getText()));
		systemConfig.setAllowedUploadImageExtension(allowedUploadImageExtensionNode.getText());
		systemConfig.setAllowedUploadMediaExtension(allowedUploadMediaExtensionNode.getText());
		systemConfig.setAllowedUploadFileExtension(allowedUploadFileExtensionNode.getText());
		systemConfig.setSmtpFromMail(smtpFromMailNode.getText());
		systemConfig.setSmtpHost(smtpHostNode.getText());
		systemConfig.setSmtpPort(Integer.valueOf(smtpPortNode.getText()));
		systemConfig.setSmtpUsername(smtpUsernameNode.getText());
		systemConfig.setSmtpPassword(smtpPasswordNode.getText());
		systemConfig.setPointScale(Double.valueOf(pointScaleNode.getText()));
		
		systemConfig.setBigPresentImageWidth(Integer.valueOf(bigPresentImageWidthNode.getText()));
		systemConfig.setBigPresentImageHeight(Integer.valueOf(bigPresentImageHeightNode.getText()));
		systemConfig.setSmallPresentImageWidth(Integer.valueOf(smallPresentImageWidthNode.getText()));
		systemConfig.setSmallPresentImageHeight(Integer.valueOf(smallPresentImageHeightNode.getText()));
		systemConfig.setThumbnailPresentImageWidth(Integer.valueOf(thumbnailPresentImageWidthNode.getText()));
		systemConfig.setThumbnailPresentImageHeight(Integer.valueOf(thumbnailPresentImageHeightNode.getText()));
		systemConfig.setDefaultBigPresentImagePath(defaultBigPresentImagePathNode.getText());
		systemConfig.setDefaultSmallPresentImagePath(defaultSmallPresentImagePathNode.getText());
		systemConfig.setDefaultThumbnailPresentImagePath(defaultThumbnailPresentImagePathNode.getText());
		
		OsCacheConfigUtil.putInCache(PRESENT_CONFIG_CACHE_KEY, systemConfig);
		return systemConfig;
	}
	
	/**
	 * 更新系统配置信息
	 * 
	 * @param systemConfig
	 *          SystemConfig对象
	 */
	public static void update(SystemConfig systemConfig) {
		File configFile = null;
		Document document = null;
		try {
			String configFilePath = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath() + CONFIG_FILE_NAME;
			configFile = new File(configFilePath);
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(configFile);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		Element rootElement = document.getRootElement();
		Element systemConfigElement = rootElement.element("systemConfig");
		Node systemNameNode = document.selectSingleNode("/shop/systemConfig/systemName");
		Node systemVersionNode = document.selectSingleNode("/shop/systemConfig/systemVersion");
		Node systemDescriptionNode = document.selectSingleNode("/shop/systemConfig/systemDescription");
		Node isInstalledNode = document.selectSingleNode("/shop/systemConfig/isInstalled");
		Node shopNameNode = document.selectSingleNode("/shop/systemConfig/shopName");
		Node shopUrlNode = document.selectSingleNode("/shop/systemConfig/shopUrl");
		Node shopLogoNode = document.selectSingleNode("/shop/systemConfig/shopLogo");
		Node hotSearchNode = document.selectSingleNode("/shop/systemConfig/hotSearch");
		Node metaKeywordsNode = document.selectSingleNode("/shop/systemConfig/metaKeywords");
		Node metaDescriptionNode = document.selectSingleNode("/shop/systemConfig/metaDescription");
		Node addressNode = document.selectSingleNode("/shop/systemConfig/address");
		Node phoneNode = document.selectSingleNode("/shop/systemConfig/phone");
		Node zipCodeNode = document.selectSingleNode("/shop/systemConfig/zipCode");
		Node emailNode = document.selectSingleNode("/shop/systemConfig/email");
		Node currencyTypeNode = document.selectSingleNode("/shop/systemConfig/currencyType");
		Node currencySignNode = document.selectSingleNode("/shop/systemConfig/currencySign");
		Node currencyUnitNode = document.selectSingleNode("/shop/systemConfig/currencyUnit");
		Node priceScaleNode = document.selectSingleNode("/shop/systemConfig/priceScale");
		Node priceRoundTypeNode = document.selectSingleNode("/shop/systemConfig/priceRoundType");
		Node orderScaleNode = document.selectSingleNode("/shop/systemConfig/orderScale");
		Node orderRoundTypeNode = document.selectSingleNode("/shop/systemConfig/orderRoundType");
		Node certtextNode = document.selectSingleNode("/shop/systemConfig/certtext");
		Node storeAlertCountNode = document.selectSingleNode("/shop/systemConfig/storeAlertCount");
		Node storeFreezeTimeNode = document.selectSingleNode("/shop/systemConfig/storeFreezeTime");
		Node uploadLimitNode = document.selectSingleNode("/shop/systemConfig/uploadLimit");
		Node isLoginFailureLockNode = document.selectSingleNode("/shop/systemConfig/isLoginFailureLock");
		Node loginFailureLockCountNode = document.selectSingleNode("/shop/systemConfig/loginFailureLockCount");
		Node loginFailureLockTimeNode = document.selectSingleNode("/shop/systemConfig/loginFailureLockTime");
		Node isRegisterNode = document.selectSingleNode("/shop/systemConfig/isRegister");
		Node watermarkImagePathNode = document.selectSingleNode("/shop/systemConfig/watermarkImagePath");
		Node watermarkPositionNode = document.selectSingleNode("/shop/systemConfig/watermarkPosition");
		Node watermarkAlphaNode = document.selectSingleNode("/shop/systemConfig/watermarkAlpha");
		Node bigProductImageWidthNode = document.selectSingleNode("/shop/systemConfig/bigProductImageWidth");
		Node bigProductImageHeightNode = document.selectSingleNode("/shop/systemConfig/bigProductImageHeight");
		Node smallProductImageWidthNode = document.selectSingleNode("/shop/systemConfig/smallProductImageWidth");
		Node smallProductImageHeightNode = document.selectSingleNode("/shop/systemConfig/smallProductImageHeight");
		Node thumbnailProductImageWidthNode = document.selectSingleNode("/shop/systemConfig/thumbnailProductImageWidth");
		Node thumbnailProductImageHeightNode = document.selectSingleNode("/shop/systemConfig/thumbnailProductImageHeight");
		Node defaultBigProductImagePathNode = document.selectSingleNode("/shop/systemConfig/defaultBigProductImagePath");
		Node defaultSmallProductImagePathNode = document.selectSingleNode("/shop/systemConfig/defaultSmallProductImagePath");
		Node defaultThumbnailProductImagePathNode = document.selectSingleNode("/shop/systemConfig/defaultThumbnailProductImagePath");
		Node allowedUploadImageExtensionNode = document.selectSingleNode("/shop/systemConfig/allowedUploadImageExtension");
		Node allowedUploadMediaExtensionNode = document.selectSingleNode("/shop/systemConfig/allowedUploadMediaExtension");
		Node allowedUploadFileExtensionNode = document.selectSingleNode("/shop/systemConfig/allowedUploadFileExtension");
		Node smtpFromMailNode = document.selectSingleNode("/shop/systemConfig/smtpFromMail");
		Node smtpHostNode = document.selectSingleNode("/shop/systemConfig/smtpHost");
		Node smtpPortNode = document.selectSingleNode("/shop/systemConfig/smtpPort");
		Node smtpUsernameNode = document.selectSingleNode("/shop/systemConfig/smtpUsername");
		Node smtpPasswordNode = document.selectSingleNode("/shop/systemConfig/smtpPassword");
		Node pointTypeNode = document.selectSingleNode("/shop/systemConfig/pointType");
		Node pointScaleNode = document.selectSingleNode("/shop/systemConfig/pointScale");
		
		if(systemNameNode == null){
			systemNameNode = systemConfigElement.addElement("systemName");
		}
		if(systemVersionNode == null){
			systemVersionNode = systemConfigElement.addElement("systemVersion");
		}
		if(systemDescriptionNode == null){
			systemDescriptionNode = systemConfigElement.addElement("systemDescription");
		}
		if(isInstalledNode == null){
			isInstalledNode = systemConfigElement.addElement("isInstalled");
		}
		if(shopNameNode == null){
			shopNameNode = systemConfigElement.addElement("shopName");
		}
		if(shopUrlNode == null){
			shopUrlNode = systemConfigElement.addElement("shopUrl");
		}
		if(shopLogoNode == null){
			shopLogoNode = systemConfigElement.addElement("shopLogo");
		}
		if(hotSearchNode == null){
			hotSearchNode = systemConfigElement.addElement("hotSearch");
		}
		if(metaKeywordsNode == null){
			metaKeywordsNode = systemConfigElement.addElement("metaKeywords");
		}
		if(metaDescriptionNode == null){
			metaDescriptionNode = systemConfigElement.addElement("metaDescription");
		}
		if(addressNode == null){
			addressNode = systemConfigElement.addElement("address");
		}
		if(phoneNode == null){
			phoneNode = systemConfigElement.addElement("phone");
		}
		if(zipCodeNode == null){
			zipCodeNode = systemConfigElement.addElement("zipCode");
		}
		if(emailNode == null){
			emailNode = systemConfigElement.addElement("email");
		}
		if(currencyTypeNode == null){
			currencyTypeNode = systemConfigElement.addElement("currencyType");
		}
		if(currencySignNode == null){
			currencySignNode = systemConfigElement.addElement("currencySign");
		}
		if(currencyUnitNode == null){
			currencyUnitNode = systemConfigElement.addElement("currencyUnit");
		}
		if(priceScaleNode == null){
			priceScaleNode = systemConfigElement.addElement("priceScale");
		}
		if(priceRoundTypeNode == null){
			priceRoundTypeNode = systemConfigElement.addElement("priceRoundType");
		}
		if(orderScaleNode == null){
			orderScaleNode = systemConfigElement.addElement("orderScale");
		}
		if(orderRoundTypeNode == null){
			orderRoundTypeNode = systemConfigElement.addElement("orderRoundType");
		}
		if(certtextNode == null){
			certtextNode = systemConfigElement.addElement("certtext");
		}
		if(storeAlertCountNode == null){
			storeAlertCountNode = systemConfigElement.addElement("storeAlertCount");
		}
		if(storeFreezeTimeNode == null){
			storeFreezeTimeNode = systemConfigElement.addElement("storeFreezeTime");
		}
		if(uploadLimitNode == null){
			uploadLimitNode = systemConfigElement.addElement("uploadLimit");
		}
		if(isLoginFailureLockNode == null){
			isLoginFailureLockNode = systemConfigElement.addElement("isLoginFailureLock");
		}
		if(loginFailureLockCountNode == null){
			loginFailureLockCountNode = systemConfigElement.addElement("loginFailureLockCount");
		}
		if(loginFailureLockTimeNode == null){
			loginFailureLockTimeNode = systemConfigElement.addElement("loginFailureLockTime");
		}
		if(isRegisterNode == null){
			isRegisterNode = systemConfigElement.addElement("isRegister");
		}
		if(watermarkImagePathNode == null){
			watermarkImagePathNode = systemConfigElement.addElement("watermarkImagePath");
		}
		if(watermarkPositionNode == null){
			watermarkPositionNode = systemConfigElement.addElement("watermarkPosition");
		}
		if(watermarkAlphaNode == null){
			watermarkAlphaNode = systemConfigElement.addElement("watermarkAlpha");
		}
		if(bigProductImageWidthNode == null){
			bigProductImageWidthNode = systemConfigElement.addElement("bigProductImageWidth");
		}
		if(bigProductImageHeightNode == null){
			bigProductImageHeightNode = systemConfigElement.addElement("bigProductImageHeight");
		}
		if(smallProductImageWidthNode == null){
			smallProductImageWidthNode = systemConfigElement.addElement("smallProductImageWidth");
		}
		if(smallProductImageHeightNode == null){
			smallProductImageHeightNode = systemConfigElement.addElement("smallProductImageHeight");
		}
		if(thumbnailProductImageWidthNode == null){
			thumbnailProductImageWidthNode = systemConfigElement.addElement("thumbnailProductImageWidth");
		}
		if(thumbnailProductImageHeightNode == null){
			thumbnailProductImageHeightNode = systemConfigElement.addElement("thumbnailProductImageHeight");
		}
		if(defaultBigProductImagePathNode == null){
			defaultBigProductImagePathNode = systemConfigElement.addElement("defaultBigProductImagePath");
		}
		if(defaultSmallProductImagePathNode == null){
			defaultSmallProductImagePathNode = systemConfigElement.addElement("defaultSmallProductImagePath");
		}
		if(defaultThumbnailProductImagePathNode == null){
			defaultThumbnailProductImagePathNode = systemConfigElement.addElement("defaultThumbnailProductImagePath");
		}
		if(allowedUploadImageExtensionNode == null){
			allowedUploadImageExtensionNode = systemConfigElement.addElement("allowedUploadImageExtension");
		}
		if(allowedUploadMediaExtensionNode == null){
			allowedUploadMediaExtensionNode = systemConfigElement.addElement("allowedUploadMediaExtension");
		}
		if(allowedUploadFileExtensionNode == null){
			allowedUploadFileExtensionNode = systemConfigElement.addElement("allowedUploadFileExtension");
		}
		if(smtpFromMailNode == null){
			smtpFromMailNode = systemConfigElement.addElement("smtpFromMail");
		}
		if(smtpHostNode == null){
			smtpHostNode = systemConfigElement.addElement("smtpHost");
		}
		if(smtpPortNode == null){
			smtpPortNode = systemConfigElement.addElement("smtpPort");
		}
		if(smtpUsernameNode == null){
			smtpUsernameNode = systemConfigElement.addElement("smtpUsername");
		}
		if(smtpPasswordNode == null){
			smtpPasswordNode = systemConfigElement.addElement("smtpPassword");
		}
		if(pointTypeNode == null){
			pointTypeNode = systemConfigElement.addElement("pointType");
		}
		if(pointScaleNode == null){
			pointScaleNode = systemConfigElement.addElement("pointScale");
		}
		
		systemNameNode.setText(systemConfig.getSystemName());
		systemVersionNode.setText(systemConfig.getSystemVersion());
		systemDescriptionNode.setText(systemConfig.getSystemDescription());
		isInstalledNode.setText(systemConfig.getIsInstalled().toString());
		shopNameNode.setText(systemConfig.getShopName());
		shopUrlNode.setText(StringUtils.removeEnd(systemConfig.getShopUrl(), "/"));
		shopLogoNode.setText(systemConfig.getShopLogo());
		hotSearchNode.setText(systemConfig.getHotSearch());
		metaKeywordsNode.setText(systemConfig.getMetaKeywords());
		metaDescriptionNode.setText(systemConfig.getMetaDescription());
		addressNode.setText(systemConfig.getAddress());
		phoneNode.setText(systemConfig.getPhone());
		zipCodeNode.setText(systemConfig.getZipCode());
		emailNode.setText(systemConfig.getEmail());
		currencyTypeNode.setText(String.valueOf(systemConfig.getCurrencyType()));
		currencySignNode.setText(systemConfig.getCurrencySign());
		currencyUnitNode.setText(systemConfig.getCurrencyUnit());
		priceScaleNode.setText(String.valueOf(systemConfig.getPriceScale()));
		priceRoundTypeNode.setText(String.valueOf(systemConfig.getPriceRoundType()));
		orderScaleNode.setText(String.valueOf(systemConfig.getOrderScale()));
		orderRoundTypeNode.setText(String.valueOf(systemConfig.getOrderRoundType()));
		certtextNode.setText(systemConfig.getCerttext());
		storeAlertCountNode.setText(String.valueOf(systemConfig.getStoreAlertCount()));
		storeFreezeTimeNode.setText(String.valueOf(systemConfig.getStoreFreezeTime()));
		uploadLimitNode.setText(String.valueOf(systemConfig.getUploadLimit()));
		isLoginFailureLockNode.setText(String.valueOf(systemConfig.getIsLoginFailureLock()));
		loginFailureLockCountNode.setText(String.valueOf(systemConfig.getLoginFailureLockCount()));
		loginFailureLockTimeNode.setText(String.valueOf(systemConfig.getLoginFailureLockTime()));
		isRegisterNode.setText(String.valueOf(systemConfig.getIsRegister()));
		watermarkImagePathNode.setText(systemConfig.getWatermarkImagePath());
		watermarkPositionNode.setText(String.valueOf(systemConfig.getWatermarkPosition()));
		watermarkAlphaNode.setText(String.valueOf(systemConfig.getWatermarkAlpha()));
		bigProductImageWidthNode.setText(String.valueOf(systemConfig.getBigProductImageWidth()));
		bigProductImageHeightNode.setText(String.valueOf(systemConfig.getBigProductImageHeight()));
		smallProductImageWidthNode.setText(String.valueOf(systemConfig.getSmallProductImageWidth()));
		smallProductImageHeightNode.setText(String.valueOf(systemConfig.getSmallProductImageHeight()));
		thumbnailProductImageWidthNode.setText(String.valueOf(systemConfig.getThumbnailProductImageWidth()));
		thumbnailProductImageHeightNode.setText(String.valueOf(systemConfig.getThumbnailProductImageHeight()));
		defaultBigProductImagePathNode.setText(systemConfig.getDefaultBigProductImagePath());
		defaultSmallProductImagePathNode.setText(systemConfig.getDefaultSmallProductImagePath());
		defaultThumbnailProductImagePathNode.setText(systemConfig.getDefaultThumbnailProductImagePath());
		allowedUploadImageExtensionNode.setText(systemConfig.getAllowedUploadImageExtension());
		allowedUploadMediaExtensionNode.setText(systemConfig.getAllowedUploadMediaExtension());
		allowedUploadFileExtensionNode.setText(systemConfig.getAllowedUploadFileExtension());
		smtpFromMailNode.setText(systemConfig.getSmtpFromMail());
		smtpHostNode.setText(systemConfig.getSmtpHost());
		if (systemConfig.getSmtpPort() == null) {
			smtpPortNode.setText("25");
		} else {
			smtpPortNode.setText(String.valueOf(systemConfig.getSmtpPort()));
		}
		smtpUsernameNode.setText(systemConfig.getSmtpUsername());
		smtpPasswordNode.setText(systemConfig.getSmtpPassword());
		pointTypeNode.setText(systemConfig.getPointType().toString());
		pointScaleNode.setText(systemConfig.getPointScale().toString());
		try {
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();// 设置XML文档输出格式
			outputFormat.setEncoding("UTF-8");// 设置XML文档的编码类型
			outputFormat.setIndent(true);// 设置是否缩进
			outputFormat.setIndent("	");// 以TAB方式实现缩进
			outputFormat.setNewlines(true);// 设置是否换行
			XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(configFile), outputFormat);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		OsCacheConfigUtil.flushEntry(PRESENT_CONFIG_CACHE_KEY);
	}
	
	/**
	 * 刷新系统配置信息
	 * 
	 */
	public void flush() {
		OsCacheConfigUtil.flushEntry(PRESENT_CONFIG_CACHE_KEY);
	}
}