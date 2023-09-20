package aca98b;

public class OneElement {
    private float x;
    private float y;
    private float r;
    private String result;
    private String time;
    private String scriptTIme;

    public OneElement(float x, float y, float r, String result, String time, String scriptTIme){
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
        this.time = time;
        this.scriptTIme = scriptTIme;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getScriptTIme() {
        return scriptTIme;
    }

    public void setScriptTIme(String scriptTIme) {
        this.scriptTIme = scriptTIme;
    }

}
