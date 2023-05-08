package com.example.yin.controller;

import com.example.yin.common.R;
import com.example.yin.model.domain.SchoolSong;
import com.example.yin.model.request.SongRequest;
import com.example.yin.service.SchoolSongService;
import com.example.yin.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;

@RestController
public class SchoolSongController {

    @Autowired
    private SchoolSongService songService;


//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        // 文件最大10M,DataUnit提供5中类型B,KB,MB,GB,TB
//        factory.setMaxFileSize(DataSize.of(20, DataUnit.MEGABYTES));
//        // 设置总上传数据总大小10M
//        factory.setMaxRequestSize(DataSize.of(20, DataUnit.MEGABYTES));
//        return factory.createMultipartConfig();
//    }


//    // 添加歌曲
//    @PostMapping("/schoolSong/add")
//    public R addSong(SongRequest addSongRequest, @RequestParam("file") MultipartFile mpfile) {
//        return songService.addSong(addSongRequest,mpfile);
//    }
    @PostMapping("/schoolSong/add")
    public R addSong(SchoolSong schoolSong) {
                songService.save(schoolSong);
        return R.success("添加成功");
    }



    // 删除歌曲
    @DeleteMapping("/schoolSong/delete")
    public R deleteSong(@RequestParam int id) {
        return songService.deleteSong(id);
    }

    // 返回所有歌曲
    @GetMapping("/schoolSong")
    public R allSong() {
        return songService.allSong();
    }

    //TODO ok
    // 返回指定歌曲ID的歌曲
    @GetMapping("/schoolSong/detail")
    public R songOfId(@RequestParam int id) {
        return songService.songOfId(id);
    }

    // 返回指定歌手ID的歌曲
    @GetMapping("/schoolSong/singer/detail")
    public R songOfSingerId(@RequestParam int singerId) {
        return songService.songOfSingerId(singerId);
    }

    // 返回指定歌手名的歌曲
    @GetMapping("/schoolSong/singerName/detail")
    public R songOfSingerName(@RequestParam String name) {
        return songService.songOfSingerName('%' + name + '%');
    }

    // 更新歌曲信息
    @PostMapping("/schoolSong/update")
    public R updateSongMsg(@RequestBody SongRequest updateSongRequest) {
        return songService.updateSongMsg(updateSongRequest);
    }

    // 更新歌曲图片
    @PostMapping("/schoolSong/img/update")
    public R updateSongPic(@RequestParam("file") MultipartFile urlFile, @RequestParam("id") int id) {
        return songService.updateSongPic(urlFile, id);
    }

    // 更新歌曲
    @PostMapping("/schoolSong/url/update")
    public R updateSongUrl(@RequestParam("file") MultipartFile urlFile, @RequestParam("id") int id) {
        return songService.updateSongUrl(urlFile, id);
    }
}
