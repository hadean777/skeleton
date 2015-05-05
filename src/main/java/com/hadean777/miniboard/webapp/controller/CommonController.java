package com.hadean777.miniboard.webapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hadean777.miniboard.AppConstants;


@Controller
public class CommonController {
	
/*	@Autowired
	@Qualifier(AppConstants.MANAGER_BEAN_FILE_MANAGER)
	private FileManager fileManager;*/
	
	@RequestMapping("/common/loginPage.do")
	public String goToLoginPage() {
		return "login";
	}

/*	@RequestMapping("/secure/common/welcomeUser.do")
	public String goToUserWelcomePage(Model p_model) {
		//TODO: retrieve from DB
		p_model.addAttribute( AppConstants.APP_PROPERTY_MINUTES_INACTIVE, AppConstants.APP_PROPERTY_MINUTES_INACTIVE_DEFAULT_VALUE );
		return "welcome_user";
	}*/

	@RequestMapping("/secure/common/screenLayout.do")	
	public String screenWithLeftMenu(@RequestParam(value="screen", required=false) String p_screen,
			Model p_model) {
		p_model.addAttribute( "screen", p_screen );
		return "screenLayout";
	}

/*	@RequestMapping("/secure/common/pingRequest.do")
	public @ResponseBody String pingRequest() {
		//It is just ping that allow to update last active time for session
		return "success";
	}*/
	
	
/*	@RequestMapping(value = "/images/image.do", method = RequestMethod.GET)
	public void getImage(@RequestParam(value="id") int imageId, HttpServletResponse p_response) {
        try
        {
        	FileModel fileModel = fileManager.getFileById(imageId);

            byte[] content = fileModel.getContent();
            String mimeType = fileModel.getMimeType();
            String fileName = fileModel.getFileName();

            p_response.setContentType( mimeType );
            p_response.setHeader( "Pragma", "private" );
            p_response.setHeader( "Cache-Control", "private, must-revalidate" );
            p_response.setHeader( "Expires", "0" );
            p_response.setDateHeader( "Last-Modified", System.currentTimeMillis() );
            if( "application/octet-stream".equals(mimeType))
            {
                p_response.setHeader( "Content-Disposition", "attachment;filename=\"" +  fileName + "\"" );
            }
            else
            {
                if (StringUtils.isNotEmpty(fileName) && fileName.indexOf(";")!=-1)
                    fileName = fileName.replaceAll(";",",");
                p_response.setHeader( "Content-Disposition", "inline;filename=\"" + fileName + "\"" );
            }
            p_response.setHeader( "Content-Transfer-Encoding", "binary" );
            //p_response.setCharacterEncoding( attachment.getCharacterSet() );
            p_response.setContentLength( content.length );
            p_response.getOutputStream().write( content );
            p_response.getOutputStream().close();
        }
        catch ( IOException e )
        {
        }
	}*/
}
