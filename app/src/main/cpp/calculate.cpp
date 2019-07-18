#include <jni.h>

extern "C"
JNIEXPORT jint JNICALL
Java_droids_rizz_calculator_MainActivity_addNumbers(JNIEnv *env, jclass type, jint a, jint b) {
    return a+b;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_droids_rizz_calculator_MainActivity_getString(JNIEnv *env, jobject instance) {
    return env->NewStringUTF("Text from CPP File");
}
