
# GmSSL for Android

环境：  
- macOS 10.15.6
- AndroidStudio 4.0.1
- NDK 21.3.6528147

## 编译

```
cd tools
./build-android-gmssl.sh
```

## 使用（静态依赖）

拷贝 `out` 下各平台下的 `lib` 中 的 `.a` 文件到 android 项目中的 `libs` 文件夹下

拷贝 `include/openssl` 到 android 项目中的 `cpp` 下

### CMake

定义 `ssl`, `crypto` 作为 `STATIC IMPORTED` libraries

```
add_library(crypto STATIC IMPORTED)
set_target_properties(crypto PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI}/libcrypto.a)

add_library(ssl STATIC IMPORTED)
set_target_properties(ssl PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI}/libssl.a)
```

添加库关联

```
target_link_libraries( # Specifies the target library.
                       native-lib
                       ssl
                       crypto
                       )
```

具体可参考 [GmSSLDemo](./example/GmSSLDemo)

## 其他

- [GmSSL](https://github.com/guanzhi/GmSSL)
- [openssl_for_ios_and_android](https://github.com/leenjewel/openssl_for_ios_and_android)
- [gmssl-for-android](https://github.com/wangp8895/gmssl-for-android)
- [GmSSLDemo](https://github.com/ikantech/GmSSLDemo)
- [在线加解密（国密）](http://i.goto327.top:85/CryptTools/SymmCrypt.aspx)