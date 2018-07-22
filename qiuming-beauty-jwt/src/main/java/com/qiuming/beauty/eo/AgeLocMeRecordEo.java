package com.qiuming.beauty.eo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * ageLocMe 测评记录实体
 * @author jiyq
 * @time 2017年12月28日 下午3:49:34
 */
public class AgeLocMeRecordEo extends BaseEo {

	private Long accountId;
	

	private String codeName;
	

	private String assessmentCode;

    private String clientInfoId;

    private String language;

    @Column(name = "age")
    @ApiModelProperty(name = "age")
    private Integer age;

    @Column(name = "birthday")
    @ApiModelProperty(name = "birthday")
    private String birthday;

    @Column(name = "gender")
    @ApiModelProperty(name = "gender")
    private Integer gender;

    @Column(name = "ethnicity")
    @ApiModelProperty(name = "ethnicity")
    private Integer ethnicity;

    @Column(name = "race_index")
    @ApiModelProperty(name = "raceIndex")
    private Integer raceIndex;

    @Column(name = "location")
    @ApiModelProperty(name = "location")
    private String location;

    @Column(name = "temperature")
    @ApiModelProperty(name = "temperature")
    private Double temperature;

    @Column(name = "humidity")
    @ApiModelProperty(name = "humidity")
    private Double humidity;

    @Column(name = "chemical_exposure")
    @ApiModelProperty(name = "chemicalExposure")
    private Integer chemicalExposure;

    @Column(name = "sun_exposure")
    @ApiModelProperty(name = "sunExposure")
    private Integer sunExposure;

    @Column(name = "skin_type")
    @ApiModelProperty(name = "skinType")
    private Integer skinType;

    @Column(name = "acne_info_viewed")
    @ApiModelProperty(name = "acneInfoViewed")
    private Integer acneInfoViewed;

    @Column(name = "skin_sensitivity")
    @ApiModelProperty(name = "skinSensitivity")
    private Integer skinSensitivity;

    @Column(name = "aha")
    @ApiModelProperty(name = "aha")
    private Integer aha;

    @Column(name = "age_spots")
    @ApiModelProperty(name = "ageSpots")
    private Integer ageSpots;

    @Column(name = "eye_wrinkles")
    @ApiModelProperty(name = "eyeWrinkles")
    private Integer eyeWrinkles;

    @Column(name = "mouth_wrinkles")
    @ApiModelProperty(name = "mouthWrinkles")
    private Integer mouthWrinkles;

    @Column(name = "forhead_wrinkles")
    @ApiModelProperty(name = "forheadWrinkles")
    private Integer forheadWrinkles;

    @Column(name = "pore_appearance")
    @ApiModelProperty(name = "poreAppearance")
    private Integer poreAppearance;

    @Column(name = "skin_firmness")
    @ApiModelProperty(name = "skinFirmness")
    private Integer skinFirmness;

    @Column(name = "skin_radiance")
    @ApiModelProperty(name = "skinRadiance")
    private Integer skinRadiance;

    @Column(name = "skin_texture")
    @ApiModelProperty(name = "skinTexture")
    private Integer skinTexture;

    @Column(name = "day_fragrance")
    @ApiModelProperty(name = "dayFragrance")
    private Integer dayFragrance;

    @Column(name = "day_moisturizer")
    @ApiModelProperty(name = "dayMoisturizer")
    private Integer dayMoisturizer;

    @Column(name = "spf")
    @ApiModelProperty(name = "spf")
    private Integer spf;

    @Column(name = "physical_spf_moisturizer")
    @ApiModelProperty(name = "physicalSPFMoisturizer")
    private Integer physicalSPFMoisturizer;

    @Column(name = "night_fragrance")
    @ApiModelProperty(name = "nightFragrance")
    private Integer nightFragrance;

    @Column(name = "night_moisturizer")
    @ApiModelProperty(name = "nightMoisturizer")
    private Integer nightMoisturizer;

    @Column(name = "code")
    @ApiModelProperty(name = "code")
    private String code;

    @Column(name = "reflected_product_code")
    @ApiModelProperty(name = "reflectedProductCode")
    private String reflectedProductCode;

    @Column(name = "cell_renewal_value")
    @ApiModelProperty(name = "cellRenewalValue")
    private Integer cellRenewalValue;

    @Column(name = "pigmentation_value")
    @ApiModelProperty(name = "pigmentationValue")
    private Integer pigmentationValue;

    @Column(name = "line_wrinkles_value")
    @ApiModelProperty(name = "lineWrinklesValue")
    private Integer lineWrinklesValue;

    @Column(name = "dm")
    @ApiModelProperty(name = "DM")
    private String DM;

    @Column(name = "nm")
    @ApiModelProperty(name = "NM")
    private String NM;

    @Column(name = "cr")
    @ApiModelProperty(name = "CR")
    private String CR;

    @Column(name = "lw")
    @ApiModelProperty(name = "LW")
    private String LW;

    @Column(name = "p")
    @ApiModelProperty(name = "P")
    private String P;

    @Column(name = "baidu_lng")
    @ApiModelProperty(name = "baiduLng")
    private String baiduLng;

    @Column(name = "baidu_lat")
    @ApiModelProperty(name = "baiduLat")
    private String baiduLat;

    @Column(name = "skin_very_dry")
    @ApiModelProperty(name = "skinVeryDry")
    private Integer skinVeryDry;

    @Column(name = "skin_dry")
    @ApiModelProperty(name = "skinDry")
    private Integer skinDry;

    @Column(name = "skin_normal")
    @ApiModelProperty(name = "skinNormal")
    private Integer skinNormal;

    @Column(name = "skin_combination")
    @ApiModelProperty(name = "skinCombination")
    private Integer skinCombination;

    @Column(name = "skin_oily")
    @ApiModelProperty(name = "skinOily")
    private Integer skinOily;

    @Column(name = "skin_very_oily")
    @ApiModelProperty(name = "skinVeryOily")
    private Integer skinVeryOily;

    @Column(name = "skin_very_firm")
    @ApiModelProperty(name = "skinVeryFirm")
    private Integer skinVeryFirm;

    @Column(name = "skin_some_firm")
    @ApiModelProperty(name = "skinSomeFirm")
    private Integer skinSomeFirm;

    @Column(name = "skin_some_sag")
    @ApiModelProperty(name = "skinSomeSag")
    private Integer skinSomeSag;

    @Column(name = "skin_very_sag")
    @ApiModelProperty(name = "skinVerySag")
    private Integer skinVerySag;

    @Column(name = "skin_very_radiant")
    @ApiModelProperty(name = "skinVeryRadiant")
    private Integer skinVeryRadiant;

    @Column(name = "skin_some_radiant")
    @ApiModelProperty(name = "skinSomeRadiant")
    private Integer skinSomeRadiant;

    @Column(name = "skin_some_dull")
    @ApiModelProperty(name = "skinSomeDull")
    private Integer skinSomeDull;

    @Column(name = "skin_very_dull")
    @ApiModelProperty(name = "skinVeryDull")
    private Integer skinVeryDull;

    @Column(name = "skin_smooth")
    @ApiModelProperty(name = "skinSmooth")
    private Integer skinSmooth;

    @Column(name = "skin_some_smooth")
    @ApiModelProperty(name = "skinSomeSmooth")
    private Integer skinSomeSmooth;

    @Column(name = "skin_some_rough")
    @ApiModelProperty(name = "skinSomeRough")
    private Integer skinSomeRough;

    @Column(name = "skin_rough")
    @ApiModelProperty(name = "skinRough")
    private Integer skinRough;

    @Column(name = "aha_stopped")
    @ApiModelProperty(name = "ahaStopped")
    private Integer ahaStopped;

    @Column(name = "aha_continued")
    @ApiModelProperty(name = "ahaContinued")
    private Integer ahaContinued;

    @Column(name = "aha_no_reaction")
    @ApiModelProperty(name = "ahaNoReaction")
    private Integer ahaNoReaction;

    @Column(name = "aha_never")
    @ApiModelProperty(name = "ahaNever")
    private Integer ahaNever;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getAssessmentCode() {
        return assessmentCode;
    }

    public void setAssessmentCode(String assessmentCode) {
        this.assessmentCode = assessmentCode;
    }

    public String getClientInfoId() {
        return clientInfoId;
    }

    public void setClientInfoId(String clientInfoId) {
        this.clientInfoId = clientInfoId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Integer ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Integer getRaceIndex() {
        return raceIndex;
    }

    public void setRaceIndex(Integer raceIndex) {
        this.raceIndex = raceIndex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Integer getChemicalExposure() {
        return chemicalExposure;
    }

    public void setChemicalExposure(Integer chemicalExposure) {
        this.chemicalExposure = chemicalExposure;
    }

    public Integer getSunExposure() {
        return sunExposure;
    }

    public void setSunExposure(Integer sunExposure) {
        this.sunExposure = sunExposure;
    }

    public Integer getSkinType() {
        return skinType;
    }

    public void setSkinType(Integer skinType) {
        this.skinType = skinType;
    }

    public Integer getAcneInfoViewed() {
        return acneInfoViewed;
    }

    public void setAcneInfoViewed(Integer acneInfoViewed) {
        this.acneInfoViewed = acneInfoViewed;
    }

    public Integer getSkinSensitivity() {
        return skinSensitivity;
    }

    public void setSkinSensitivity(Integer skinSensitivity) {
        this.skinSensitivity = skinSensitivity;
    }

    public Integer getAha() {
        return aha;
    }

    public void setAha(Integer aha) {
        this.aha = aha;
    }

    public Integer getAgeSpots() {
        return ageSpots;
    }

    public void setAgeSpots(Integer ageSpots) {
        this.ageSpots = ageSpots;
    }

    public Integer getEyeWrinkles() {
        return eyeWrinkles;
    }

    public void setEyeWrinkles(Integer eyeWrinkles) {
        this.eyeWrinkles = eyeWrinkles;
    }

    public Integer getMouthWrinkles() {
        return mouthWrinkles;
    }

    public void setMouthWrinkles(Integer mouthWrinkles) {
        this.mouthWrinkles = mouthWrinkles;
    }

    public Integer getForheadWrinkles() {
        return forheadWrinkles;
    }

    public void setForheadWrinkles(Integer forheadWrinkles) {
        this.forheadWrinkles = forheadWrinkles;
    }

    public Integer getPoreAppearance() {
        return poreAppearance;
    }

    public void setPoreAppearance(Integer poreAppearance) {
        this.poreAppearance = poreAppearance;
    }

    public Integer getSkinFirmness() {
        return skinFirmness;
    }

    public void setSkinFirmness(Integer skinFirmness) {
        this.skinFirmness = skinFirmness;
    }

    public Integer getSkinRadiance() {
        return skinRadiance;
    }

    public void setSkinRadiance(Integer skinRadiance) {
        this.skinRadiance = skinRadiance;
    }

    public Integer getSkinTexture() {
        return skinTexture;
    }

    public void setSkinTexture(Integer skinTexture) {
        this.skinTexture = skinTexture;
    }

    public Integer getDayFragrance() {
        return dayFragrance;
    }

    public void setDayFragrance(Integer dayFragrance) {
        this.dayFragrance = dayFragrance;
    }

    public Integer getDayMoisturizer() {
        return dayMoisturizer;
    }

    public void setDayMoisturizer(Integer dayMoisturizer) {
        this.dayMoisturizer = dayMoisturizer;
    }

    public Integer getSpf() {
        return spf;
    }

    public void setSpf(Integer spf) {
        this.spf = spf;
    }

    public Integer getPhysicalSPFMoisturizer() {
        return physicalSPFMoisturizer;
    }

    public void setPhysicalSPFMoisturizer(Integer physicalSPFMoisturizer) {
        this.physicalSPFMoisturizer = physicalSPFMoisturizer;
    }

    public Integer getNightFragrance() {
        return nightFragrance;
    }

    public void setNightFragrance(Integer nightFragrance) {
        this.nightFragrance = nightFragrance;
    }

    public Integer getNightMoisturizer() {
        return nightMoisturizer;
    }

    public void setNightMoisturizer(Integer nightMoisturizer) {
        this.nightMoisturizer = nightMoisturizer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReflectedProductCode() {
        return reflectedProductCode;
    }

    public void setReflectedProductCode(String reflectedProductCode) {
        this.reflectedProductCode = reflectedProductCode;
    }

    public Integer getCellRenewalValue() {
        return cellRenewalValue;
    }

    public void setCellRenewalValue(Integer cellRenewalValue) {
        this.cellRenewalValue = cellRenewalValue;
    }

    public Integer getPigmentationValue() {
        return pigmentationValue;
    }

    public void setPigmentationValue(Integer pigmentationValue) {
        this.pigmentationValue = pigmentationValue;
    }

    public Integer getLineWrinklesValue() {
        return lineWrinklesValue;
    }

    public void setLineWrinklesValue(Integer lineWrinklesValue) {
        this.lineWrinklesValue = lineWrinklesValue;
    }

    public String getDM() {
        return DM;
    }

    public void setDM(String DM) {
        this.DM = DM;
    }

    public String getNM() {
        return NM;
    }

    public void setNM(String NM) {
        this.NM = NM;
    }

    public String getCR() {
        return CR;
    }

    public void setCR(String CR) {
        this.CR = CR;
    }

    public String getLW() {
        return LW;
    }

    public void setLW(String LW) {
        this.LW = LW;
    }

    public String getP() {
        return P;
    }

    public void setP(String p) {
        P = p;
    }

    public String getBaiduLng() {
        return baiduLng;
    }

    public void setBaiduLng(String baiduLng) {
        this.baiduLng = baiduLng;
    }

    public String getBaiduLat() {
        return baiduLat;
    }

    public void setBaiduLat(String baiduLat) {
        this.baiduLat = baiduLat;
    }

    public Integer getSkinVeryDry() {
        return skinVeryDry;
    }

    public void setSkinVeryDry(Integer skinVeryDry) {
        this.skinVeryDry = skinVeryDry;
    }

    public Integer getSkinDry() {
        return skinDry;
    }

    public void setSkinDry(Integer skinDry) {
        this.skinDry = skinDry;
    }

    public Integer getSkinNormal() {
        return skinNormal;
    }

    public void setSkinNormal(Integer skinNormal) {
        this.skinNormal = skinNormal;
    }

    public Integer getSkinCombination() {
        return skinCombination;
    }

    public void setSkinCombination(Integer skinCombination) {
        this.skinCombination = skinCombination;
    }

    public Integer getSkinOily() {
        return skinOily;
    }

    public void setSkinOily(Integer skinOily) {
        this.skinOily = skinOily;
    }

    public Integer getSkinVeryOily() {
        return skinVeryOily;
    }

    public void setSkinVeryOily(Integer skinVeryOily) {
        this.skinVeryOily = skinVeryOily;
    }

    public Integer getSkinVeryFirm() {
        return skinVeryFirm;
    }

    public void setSkinVeryFirm(Integer skinVeryFirm) {
        this.skinVeryFirm = skinVeryFirm;
    }

    public Integer getSkinSomeFirm() {
        return skinSomeFirm;
    }

    public void setSkinSomeFirm(Integer skinSomeFirm) {
        this.skinSomeFirm = skinSomeFirm;
    }

    public Integer getSkinSomeSag() {
        return skinSomeSag;
    }

    public void setSkinSomeSag(Integer skinSomeSag) {
        this.skinSomeSag = skinSomeSag;
    }

    public Integer getSkinVerySag() {
        return skinVerySag;
    }

    public void setSkinVerySag(Integer skinVerySag) {
        this.skinVerySag = skinVerySag;
    }

    public Integer getSkinVeryRadiant() {
        return skinVeryRadiant;
    }

    public void setSkinVeryRadiant(Integer skinVeryRadiant) {
        this.skinVeryRadiant = skinVeryRadiant;
    }

    public Integer getSkinSomeRadiant() {
        return skinSomeRadiant;
    }

    public void setSkinSomeRadiant(Integer skinSomeRadiant) {
        this.skinSomeRadiant = skinSomeRadiant;
    }

    public Integer getSkinSomeDull() {
        return skinSomeDull;
    }

    public void setSkinSomeDull(Integer skinSomeDull) {
        this.skinSomeDull = skinSomeDull;
    }

    public Integer getSkinVeryDull() {
        return skinVeryDull;
    }

    public void setSkinVeryDull(Integer skinVeryDull) {
        this.skinVeryDull = skinVeryDull;
    }

    public Integer getSkinSmooth() {
        return skinSmooth;
    }

    public void setSkinSmooth(Integer skinSmooth) {
        this.skinSmooth = skinSmooth;
    }

    public Integer getSkinSomeSmooth() {
        return skinSomeSmooth;
    }

    public void setSkinSomeSmooth(Integer skinSomeSmooth) {
        this.skinSomeSmooth = skinSomeSmooth;
    }

    public Integer getSkinSomeRough() {
        return skinSomeRough;
    }

    public void setSkinSomeRough(Integer skinSomeRough) {
        this.skinSomeRough = skinSomeRough;
    }

    public Integer getSkinRough() {
        return skinRough;
    }

    public void setSkinRough(Integer skinRough) {
        this.skinRough = skinRough;
    }

    public Integer getAhaStopped() {
        return ahaStopped;
    }

    public void setAhaStopped(Integer ahaStopped) {
        this.ahaStopped = ahaStopped;
    }

    public Integer getAhaContinued() {
        return ahaContinued;
    }

    public void setAhaContinued(Integer ahaContinued) {
        this.ahaContinued = ahaContinued;
    }

    public Integer getAhaNoReaction() {
        return ahaNoReaction;
    }

    public void setAhaNoReaction(Integer ahaNoReaction) {
        this.ahaNoReaction = ahaNoReaction;
    }

    public Integer getAhaNever() {
        return ahaNever;
    }

    public void setAhaNever(Integer ahaNever) {
        this.ahaNever = ahaNever;
    }

    @Override
    public String toString() {
        return  "{" +"\"clientInfoId\":\""+ clientInfoId  +
                "\",\"language\":\""+ language  +
                "\",\"age\":\""+ age +
                "\",\"birthday\":\""+ birthday  +
                "\",\"gender\":"+ gender +
                ",\"ethnicity\":\""+ ethnicity +
                "\",\"raceIndex\":\""+ raceIndex +
                "\",\"location\":\""+ location  +
                (null != temperature ? ("\",\"temperature\":\""+ temperature) : "") +
                (null != humidity ? ("\",\"humidity\":\""+ humidity) : "") +
                "\",\"chemicalExposure\":\""+ chemicalExposure +
                "\",\"sunExposure\":\""+ sunExposure +
                "\",\"skinType\":\""+ skinType +  "\"" +
                (null == acneInfoViewed ? "" : ",\"acneInfoViewed\":"+ (acneInfoViewed == 1)) +
                ",\"skinSensitivity\":\""+ skinSensitivity +
                "\",\"aha\":\""+ aha +
                "\",\"ageSpots\":\""+ ageSpots +
                "\",\"eyeWrinkles\":\""+ eyeWrinkles +
                "\",\"mouthWrinkles\":\""+ mouthWrinkles +
                "\",\"forheadWrinkles\":\""+ forheadWrinkles +
                "\",\"poreAppearance\":\""+ poreAppearance +
                "\",\"skinFirmness\":\""+ skinFirmness +
                "\",\"skinRadiance\":\""+ skinRadiance +
                "\",\"skinTexture\":\""+ skinTexture +  "\"" +
                (null == dayFragrance ? "" : ",\"dayFragrance\":"+ (dayFragrance == 1)) +
                ",\"dayMoisturizer\":\""+ dayMoisturizer +  "\"" +
                (null == spf ? "" : ",\"spf\":"+ (spf == 1)) +
                (null == physicalSPFMoisturizer ? "" : ",\"physicalSPFMoisturizer\":"+ (physicalSPFMoisturizer == 1)) +
                (null == nightFragrance ? "" : ",\"nightFragrance\":"+ (nightFragrance == 1)) +
                ",\"nightFragrance\":\""+ nightFragrance +
                "\",\"nightMoisturizer\":\""+ nightMoisturizer +
                "\",\"code\":\""+ code  +
                "\",\"reflectedProductCode\":\""+ reflectedProductCode  +
                "\",\"cellRenewalValue\":\""+ cellRenewalValue +
                "\",\"pigmentationValue\":\""+ pigmentationValue +
                "\",\"lineWrinklesValue\":\""+ lineWrinklesValue +
                "\",\"DM\":\""+ DM  +
                "\",\"NM\":\""+ NM  +
                "\",\"CR\":\""+ CR  +
                "\",\"LW\":\""+ LW  +
                "\",\"P\":\""+ P  +
                "\",\"baiduLng\":\""+ baiduLng  +
                "\",\"baiduLat\":\""+ baiduLat  +  "\"" +
                (null == skinVeryDry ? "" : ",\"skinVeryDry\":"+ (skinVeryDry == 1)) +
                (null == skinDry ? "" : ",\"skinDry\":"+ (skinDry == 1)) +
                (null == skinNormal ? "" : ",\"skinNormal\":"+ (skinNormal == 1)) +
                (null == skinCombination ? "" : ",\"skinCombination\":"+ (skinCombination == 1)) +
                (null == skinOily ? "" : ",\"skinOily\":"+ (skinOily == 1)) +
                (null == skinVeryOily ? "" : ",\"skinVeryOily\":"+ (skinVeryOily == 1)) +
                (null == skinVeryFirm ? "" : ",\"skinVeryFirm\":"+ (skinVeryFirm == 1)) +
                (null == skinSomeFirm ? "" : ",\"skinSomeFirm\":"+ (skinSomeFirm == 1)) +
                (null == skinSomeSag ? "" : ",\"skinSomeSag\":"+ (skinSomeSag == 1)) +
                (null == skinVerySag ? "" : ",\"skinVerySag\":"+ (skinVerySag == 1)) +
                (null == skinVeryRadiant ? "" : ",\"skinVeryRadiant\":"+ (skinVeryRadiant == 1)) +
                (null == skinSomeRadiant ? "" : ",\"skinSomeRadiant\":"+ (skinSomeRadiant == 1)) +
                (null == skinSomeDull ? "" : ",\"skinSomeDull\":"+ (skinSomeDull == 1)) +
                (null == skinVeryDull ? "" : ",\"skinVeryDull\":"+ (skinVeryDull == 1)) +
                (null == skinSmooth ? "" : ",\"skinSmooth\":"+ (skinSmooth == 1)) +
                (null == skinSomeSmooth ? "" : ",\"skinSomeSmooth\":"+ (skinSomeSmooth == 1)) +
                (null == skinSomeRough ? "" : ",\"skinSomeRough\":"+ (skinSomeRough == 1)) +
                (null == skinRough ? "" : ",\"skinRough\":"+ (skinRough == 1)) +
                (null == ahaStopped ? "" : ",\"ahaStopped\":"+ (ahaStopped == 1)) +
                (null == ahaContinued ? "" : ",\"ahaContinued\":"+ (ahaContinued == 1)) +
                (null == ahaNoReaction ? "" : ",\"ahaNoReaction\":"+ (ahaNoReaction == 1)) +
                (null == ahaNever ? "" : ",\"ahaNoReaction\":"+ (ahaNoReaction == 1)) +
                // "skinVeryOily":false,"skinVeryFirm":false,"skinSomeFirm":false,"skinSomeSag":true,"skinVerySag":false,"skinVeryRadiant":false,
                // "skinSomeRadiant":false,"skinSomeDull":false,"skinVeryDull":true,"skinSmooth":false,"skinSomeSmooth":false,"skinSomeRough":false,"skinRough":true,"ahaStopped":false,
                // "ahaContinued":false,"ahaNoReaction":true,"ahaNever":false,
                "}";
    }

    public AgeLocMeRecordEo() {
    }
}
