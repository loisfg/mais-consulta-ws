export const generate = () => {
    const date = {
        days: [],
        weekdays: [],
        mounth: "",
        previousDays: [],
        nextDays: [],
        currentDay: 0
    }
    const now = new Date();
    const nowDays = new Date(now.getFullYear(),now.getMonth()+1, 0).getDate()
    date.weekdays = ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"];
    date.days = Array.from({length:nowDays}, (_,index) => index+1) ;


    date.currentDay = now.getDate()

    const mounths = [
        "Janeiro",
        "Fevereiro",
        "Março",
        "Abril",
        "Maio",
        "Junho",
        "Julho",
        "Agosto",
        "Setembro",
        "Outubro",
        "Novembro",
        "Dezembro",
    ];

    const lastWeekday =  new Date(now.getFullYear(),now.getMonth()+1, 0).getDay()

    let countNext = 1;
    for(let i = lastWeekday+1; i < 7; i++, countNext++)
        date.nextDays.push(countNext);
    
    const firstWeekday =  new Date(now.getFullYear(),now.getMonth(), 1).getDay()

    let lastDayPreviousMounth = new Date(now.getFullYear(),now.getMonth(), 0).getDate() 
    
    for(let i = firstWeekday-1; i >= 0 ; i--, lastDayPreviousMounth--)
        date.previousDays.push(lastDayPreviousMounth);
    
    date.mounth = mounths[now.getMonth()];

    return date;
}
/*
    CAPTURAR: 
        *dia mês e ano atual
    ITENS CALENDARIO: 
        -------------------------*Todos os dias do mês
        -------------------------*todos os dias da semana
        -------------------------*dias anteriores da primeira semana
        -------------------------*dias posteriores a última semana

    Dias devem ser settados no banco com dia mes e ano
*/