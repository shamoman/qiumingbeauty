package com.qiuming.beauty.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiuming.beauty.dto.*;
import com.qiuming.beauty.eo.ItItemEo;
import com.qiuming.beauty.eo.ItShopBarberEo;
import com.qiuming.beauty.eo.ItShopEo;
import com.qiuming.beauty.utils.HttpClientUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author shilei
 * @Date 2017/6/9.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String heelo(){
        return "HELLO, THIS IS QIU MING BEAUTY SHOPPING CART";
    }

    @RequestMapping("/facebook/login")
    public RestResponse testFaceBook(String code){
//        ThirdOauthDto oauthDto = getOauthToken("188622978654750","c6d572ba550b3883d0d0c26f171e8eef",code);
        ThirdUserInfoDto result = getUserInfo("EAACrjTWjoh4BAG2mjEZCZCQ124uyRhZBF02iwgZC6Ef5ngV47eT5jtjOpeWQsjFI96irGdoA8nsAngWoAJf8BR1hhM5SQYzTgL7SXVbo61OOFgJQKj910cE7jKaS7FJbtNDKZABEgMgCLXgvMoSSPUuZAkezzmf9mcCtIqbRdIRgc5A0zCccVUCW0C4KEpc8WLgJHlnCqth1yD1DqP5xRB");
        return new RestResponse(result);
    }

    public static void main(String[] args) {
//        ThirdOauthDto oauthDto = getOauthToken("188622978654750","c6d572ba550b3883d0d0c26f171e8eef","");
        System.out.println("test just so so");
//        getUserInfo(oauthDto.getAccessToken());
    }

    public static ThirdUserInfoDto getUserInfo(String accessToken) {
        String fields = "id,name,birthday,gender,hometown";
        StringBuilder params = new StringBuilder("https://graph.facebook.com/oauth/access_token");
        params.append("?access_token=").append(accessToken);
        params.append("&fields=").append(fields);
        String resultJson = null;
        try {
            resultJson = HttpClientUtil.sendRequest(params.toString(),null, 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSON.parseObject(resultJson);
        ThirdUserInfoDto dto = new ThirdUserInfoDto();
        dto.setOpenId((String)jsonObject.get("id"));
        dto.setNickName((String)jsonObject.get("name"));
        dto.setChannelName("facebook");
        dto.setThirdToken(accessToken);
        return dto;
    }


    public static ThirdOauthDto getOauthToken(String appId, String appSecret, String code) {
        StringBuilder params = new StringBuilder();
        params.append("https://graph.facebook.com/v3.0/oauth/access_token");
        params.append("?client_id=").append(appId);
        params.append("&client_secret=").append(appSecret);
        params.append("&code=").append(code);
//        System.out.println("FaceBook回调URI:{}", VariableConstants.REDIRECT_URI_FACEBOOK);
//        params.append("&redirect_uri=").append(VariableConstants.REDIRECT_URI_FACEBOOK);
        String resultJson = null;
        try {
            resultJson = HttpClientUtil.sendRequest(params.toString(), null,10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("===获取FaceBook授权信息 getOauthToken resultJson = {}" + resultJson);
        if (resultJson.contains("callback")) {
//            logger.error("===获取Facebook授权信息 getOauthToken resultJson = {}", resultJson);
            return null;
        } else {
            ThirdOauthDto thirdOauthDto = new ThirdOauthDto();
            String[] oauthResult = resultJson.split("&");
            Map<String, String> paramMap = new HashMap(20);
            String[] var8 = oauthResult;
            int var9 = oauthResult.length;

            for(int var10 = 0; var10 < var9; ++var10) {
                String param = var8[var10];
                int index = param.indexOf("=");
                if (-1 != index) {
                    paramMap.put(param.substring(0, index), param.substring(index + 1));
                }
            }
//
            thirdOauthDto.setAccessToken((String)paramMap.get("access_token"));
            thirdOauthDto.setExpiresIn(Integer.valueOf((String)paramMap.get("expires_in")));
            thirdOauthDto.setRefreshToken((String)paramMap.get("refresh_token"));
            return thirdOauthDto;
        }
    }

    @RequestMapping("/users")
    public String getUsers() {
        return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
                "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public RestResponse upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        if(!file.isEmpty()) {
        }
        System.out.println("file | " + JSON.toJSONString(file));
        Workbook workbook = null;
        File file1 = null;
        try {
            String filePath = request.getSession().getServletContext().getRealPath("/") + "resource/";
            File targetFile = new File(filePath);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            FileOutputStream out = new FileOutputStream(filePath + file.getOriginalFilename());
            out.write(file.getBytes());
            out.flush();
            out.close();
            file1 = new File(filePath + file.getOriginalFilename());
//            InputStream fileInputStream = file.getInputStream();
            FileInputStream fileInputStream = new FileInputStream(file1);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
//            logger.info("上传excel 文件转换报错----------------- | {}", e.getMessage());
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheet("Sheet1");
        Integer romLength = sheet.getLastRowNum();
        System.out.println("行数" + romLength);
        Row row;
        String userName;
        String mobile;
        Map dto;
        List<Map> dtos = new ArrayList<>();
        int i = 1;
        try {
            for (i = 1; i < romLength; i++) {
                dto = new HashMap();
                row = sheet.getRow(i);
                userName = getUserNameDto(row.getCell(0));
                mobile = getUserNameDto(row.getCell(1));
                if (StringUtils.isEmpty(userName) && StringUtils.isEmpty(mobile)) {
                    break;
                }
                dto.put("userName", userName);
                dto.put("mobile", mobile);
                dtos.add(dto);
            }
            System.out.println(JSON.toJSONString(dtos));
        } catch (Exception e) {
            System.out.println(("第{}行解析错误" + i));
            e.printStackTrace();
        } finally {
            file1.delete();
        }
        return null;
    }


    private String getUserNameDto(Cell cell){
        String result = null;
        if (CellType.NUMERIC == cell.getCellTypeEnum()) {
            result = String.valueOf(cell.getNumericCellValue());
        } else {
            result = cell.getStringCellValue();
        }
        return result;
    }

}
