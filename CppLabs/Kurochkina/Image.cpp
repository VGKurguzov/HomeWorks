#include <iostream>
#include <string>

using namespace std;

class Image
{
public:
	
    void GetImageInfo()
    {
        for(int i =0;i < LEN;i++)
        {
           cout << "Pixel #" << i+1 << ": " << pixels[i].GetPixelInfo()<<endl;
        }
    }

private:
    class Pixel
    {
    private:
        int r;
        int g;
        int b;
    public:
        Pixel(int r, int g, int b)
        {
            this->r=r;
            this->g=g;
            this->b=b;
        }
        string GetPixelInfo()
        {
            return " r=" + to_string(r) + " g=" + to_string(g) + " b=" + to_string(b);
        }

    };

    static const int LEN = 4;

    Pixel pixels[LEN]
    {
    Pixel(1,67,89),Pixel(0,0,255),Pixel(6,169,250),Pixel(255,255,255)
    };
};

int main()
{
    Image img;
    img.GetImageInfo();

    return 0;
}

