@RestController
@RequestMapping("/api/barbers")
public class BarberController {
    @Autowired
    private BarberRepository barberRepository;

    @GetMapping
    public List<Barber> getAllBarbers() {
        return barberRepository.findAll();
    }

    @GetMapping("/{id}")
    public Barber getBarberById(@PathVariable Long id) {
        return barberRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Barber createBarber(@RequestBody Barber barber) {
        return barberRepository.save(barber);
    }

    @PutMapping("/{id}")
    public Barber updateBarber(@PathVariable Long id, @RequestBody Barber barber) {
        Barber existingBarber = barberRepository.findById(id).orElseThrow();
        existingBarber.setName(barber.getName());
        existingBarber.setEmail(barber.getEmail());
        return barberRepository.save(existingBarber);
    }

    @DeleteMapping("/{id}")
    public void deleteBarber(@PathVariable Long id) {
        barberRepository.deleteById(id);
    }
}