import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    // Skenario: 50 user palsu menyerbu API secara bersamaan
    vus: 50,          
    // Durasi: Lakukan penyerbuan ini selama 20 detik
    duration: '20s',  
};

export default function () {
    // Tembak API Buah lokal Anda
    const res = http.get('http://localhost:8080/api/buah');
    
    // Keamanan Data: Pastikan server merespons dengan status 200 OK
    check(res, {
        'status adalah 200': (r) => r.status === 200,
    });

    // Jeda 0.1 detik sebelum user palsu menembak lagi (biar realistis)
    sleep(0.1); 
}