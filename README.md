# progettoMarti
Progetto Basi Dati Marti<strong>COMPLETED!!!</strong>

# DONE:
- model definitivi
- rework controller e jsp parte 1: Home/Admin e Prodotti/Vista Prodotti     <strong>funzionante</strong>
- rework controller e jsp parte 2: registrazione clienti     <strong>funzionante</strong>
- rework cart REST services completato     <strong>funzionante</strong>
- model, dao, services, controller per gli ordini implementati      <strong>funzionante</strong>
- checkout flow, payment(seen as order submitted), shippingaddress declaration and order confirmation <strong>funzionante</strong>
- gestione utenti e gestione ordini/stati ordini completata <strong>funzionante</strong>
- cambiate le relazioni per semplificare gli ordini <strong>funzionante</strong>
- date added to orders <strong>funzionante</strong>
- Possibilità di visualizzare gli ordini effettuati e di marcarli come consegnati <strong>funzionante</strong>
- pagina utente con ordini, dati utente e indirizzi, gli ultimi due modificabili, completata <strong>funzionante</strong>
- all'utente non e' piu' possibile vedere prodotti inattivi o comprarli <strong>funzionante</strong>
- aggiunte sotto categorie ai prodotti, e modificato tutte le pagine di editing/aggiunta dei prodotti <strong>funzionante</strong>
- barra di ricerca aggiunta, che ricerca il campo inserito dall'utente su nome prodotto, categoria, sottocategoria e descrizione del prodotto <strong>funzionante</strong>
- ora cliccando products si viene portati alla pagina delle categorie e sotto categorie, che linkano i prodotti per tali categorie/sottocategorie <strong>funzionante</strong>
- vetrina e area promo completate <strong>funzionante</strong>
- gestione quantita prodotti in stock in seguito ad acquisto, all'acquisto e nel carrello completata <strong>funzionante</strong>
- OPZIONALE: gestione tracking completata <strong>funzionante</strong>
- added faq page <strong>funzionante</strong>
- added password encoding <strong>funzionante</strong>
- added email sending for registration and order placement <strong>funzionante</strong>
- added email sending for customer support <strong>funzionante</strong>
- DAO, controller e Servizi implementati totalmente per i punti sopra svolti <strong>funzionante</strong>

# DA RIVEDERE?
- <s>forse è meglio non mettere le password in chiaro nel db</s>
- 

# TO DO:
- <s>registrazione clienti</s>
- <s>cart controller</s>
- <s>manca completamente la gestione delle quantità prodotti, al momento non sono in grado di controllare che non vengano venduti più prodotti di quelli disponibili, ne di cambiare manualmente le quantità dei prodotti nel carrello</s>
- <s>creazione ordine cliente</s>
- <s>simulazione checkout</s>
- <s> gestione ordini e clienti da parte dell'admin </s>
- <s>capacità di navigare il catalogo per marca, tipo, ricerca libera (uso di un plugin third party?)</s>
- <s>da richiesta gli admin dovrebbero poter gestire gli altri admin <em>(devo trovare un modo oltre alle autorita riconosciute dalla      spring security, che sono ROLE_USER E ROLE_ADMIN)</em></s>
- <s>Gestione di prodotti in push (per cui spingere la vendita) con inserimento in una “vetrina in home page” o in un area promo
  <em>La vetrina la ho, bisogna mettere le immagini con i relativi link ai prodotti ( o ad una categoria di prodotti)</em></s>
- <s>Possibilità di visualizzare lo stato dell’ordine e lo storico degli ordini effettuati</s>
- <s><strong>Opzionale (o per progetto in 2 persone)</strong>: gestione del tracking dell’ordine, con simulazione di tutti i
     cambi di stato (consegnato al corriere, in viaggio, consegnato al destinatario, ecc.)
     <em> Sarebbe carino da fare e forse neanche troppo impegnativo, vediamo quando finisco le basi </em></s>
- rework della grafica/testi

# MIGLIORAMENTI NECESSARI/KNOWN ISSUES:
- <s><strong>KNOWN ISSUE:</strong> ogni tanto il javascript che si occupa di gestire il carrello ritorna totali dei carrelli nulli</s>
- <s>sviluppare un modo per cambiare la quantita degli oggetti nel carrello, non solo rimuoverli in blocco, con un refresh automatico del    prezzo totale basato sulla quantita aggiornata a mano dall'utente</s>
- <s> cambiando l'url nella visione del carrello, risulta possibile accedere ai carrelli di altri utenti, poichè il formato dell'url risulta
                                          
                                          http://localhost:8080/customer/cart/1
                                          
 dove l'int rappresenta il cartId univoco per il cliente </s>
 - se modifico un prodotto già esistente come admin, la modifica dell'immagine non funziona sempre <s>(il perchè è un mistero)</s>
   <em> A quanto pare non salva fino al restart dell'app, probabilmente perche sono all'interno del progetto. Bisognerebbe provare a salvarli in una cartella esterna temporanea, passandone il path al file xml.
Altra opzione e' capire come funziona l'inserimento delle immagini in un db, ma non avrei voglia di rimettere mano ai modelli</em>
 - <s>se come admin metto un prodotto "INACTIVE", lo posso comunque vedere lo stesso nella lista prodotti. Ora questo mi può andare bene per la visione dell'admin (anche se deve essere segnalato in qualche modo), ma l'utente non deve poterli vedere. Tantomeno ordinarli, perchè adesso se li vede li può anche ordinare. All'infinito. (lol) </s>
 - <s>modificare il checkout flow (un po' di ricerca necessaria) in modo tale che se il cliente non completa il checkout, lo stato dell'ordine risulta "nocheckout", o ancora meglio, quando clicco per andare al checkout non creo l'ordine direttamente come succede adesso, ma lo faccio a checkout completato</s>
 

# Richieste originali:

Un’azienda che commercializza prodotti di elettronica di consumo (è possibile scegliere qualsiasi altra
merce o servizio da vendere) deve commissionare un applicativo web per vendere i suoi prodotti on line
che abbia le seguente caratteristiche:
  1. Possibilità di visualizzare il catalogo prodotti, navigabile per categoria merceologica, marchio,
     ricerca libera, ecc. Possibilità di vedere il singolo prodotto con tutti i dettagli e le caratteristiche
  2. Gestione di prodotti in push (per cui spingere la vendita) con inserimento in una “vetrina in home
     page” o in un area promo
  3. Opzionale (o per progetto in 2 persone): possibilità di visualizzare prodotti graditi al consumatore
     per analogia con lo storico prodotti visualizzati dall’utente,
  4. Opzionale (o per progetto in 2 persone): gestione di una wish list (lista dei desideri)
  5. Possibilità di inserire prodotti nel carrello e di effettuare l’acquisto di più prodotti in diverse
     quantità. Predisporre la gestione dei prezzi, del totale carrello, la gestione della disponibilità di
     magazzino, impedendo di poter acquistare quantità non disponibili
  6. Possibilità di inserire l’indirizzo di consegna, di simulare il pagamento, e di confermare l’ordine
  7. Possibilità di visualizzare lo stato dell’ordine e lo storico degli ordini effettuati
  8. Opzionale (o per progetto in 2 persone): gestione di coupon o buoni sconto in fase di acquisto,
     possibilità di visualizzare il tracking dell’ordine in consegna.
  9. Possibilità degli amministratori di visualizzare gli utenti, verificare il numero degli ordini per utente,
     bloccare eventuali utenti, gestire gli altri utenti amministratori
  10. Possibilità di gestire il catalogo (inserimento, modifica, blocco prodotti), le categorie
     merceologiche, i brand, ecc. Possibilità di gestire la disponibilità di magazzino
  11. Possibilità di visualizzare gli ordini effettuati e di marcarli come consegnati
  12. Opzionale (o per progetto in 2 persone): gestione del tracking dell’ordine, con simulazione di tutti i
     cambi di stato (consegnato al corriere, in viaggio, consegnato al destinatario, ecc.)
  13. Opzionale (o per progetto in 2 persone): gestione dei coupon o buoni sconto

Il sistema prevede che le categorie di utenti sia così rappresentata:

• utenti pubblici che possono solamente eseguire i punti 1 e 2 ed eventualmente registrarsi.

• utenti registrati che possono effettuare i punti fino al punto 8 compreso

• amministratori che possono effettuare i punti dal 9 al 14 compresi 
